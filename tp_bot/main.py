import asyncio
from aiogram import Bot, Dispatcher, executor
from aiogram.contrib.fsm_storage.memory import MemoryStorage
from aiogram.dispatcher import FSMContext
from aiogram.dispatcher.filters import BoundFilter
from aiogram.dispatcher.filters.state import State, StatesGroup
from aiogram.types import (
    Message as M,
    CallbackQuery as CQ,
    InlineKeyboardMarkup as IKB,
    InlineKeyboardButton as IKBB,
    ReplyKeyboardMarkup as KB,
    KeyboardButton as KBB,
    ContentType,
    ReplyKeyboardMarkup,
    InlineKeyboardMarkup,
    ReplyKeyboardRemove,
    ForceReply,
)
from loguru import logger
from classes import DB, Telegram_DB
import utils
import configuration

token = "1868545953:AAGYVdFiTuH7wH3zi97u8pee-NnzdEloIeg"
storage = MemoryStorage()
bot = Bot(token=token)
dp = Dispatcher(bot=bot, storage=storage)
db = DB()
tg_db = Telegram_DB()
util = utils.Utils()
config = configuration.Config()


class AdminPanel(StatesGroup):
    enter = State()
    mainPanel = State()
    scheduleSettings = State()

class Notifications(StatesGroup):
    enter = State()
    mainPanel = State()
    scheduleSettings = State()


@dp.message_handler(commands=['start'])
async def start(m: M):
    try:
        tg_db.save_person(m.from_user.id, m.text.split()[-1])
    except Exception:
        print('User already added.')
    mp = KB(resize_keyboard=True)
    if tg_db.get_person_notifications_by_tgid(m.from_user.id)[0]:
        mp.add(KBB('Включить уведомления'))
    else:
        mp.add(KBB('Выключить уведомления'))
    await bot.send_message(m.from_user.id,
                           f'{m.from_user.full_name}, здравствуйте!\n\nВас приветствует чат-бот сервиса "AviaProject".\nТеперь вы подписаны на рассылку информации от нашего сервиса. Надеемся, что вы найдёте её полезной',reply_markup=mp)


# @dp.message_handler()
# async def echo(m:M):
#     mp = KB(resize_keyboard=True)
#     if tg_db.get_person_notifications_by_tgid(m.from_user.id)[0]:
#         mp.add(KBB('Включить уведомления'))
#     else:
#         mp.add(KBB('Выключить уведомления'))
#     await bot.send_message(m.from_user.id,'Бот не умеет общаться(',reply_markup=mp)

@dp.message_handler(lambda m: m.text.split()[-1]=='уведомления')
async def change_notifications(m:M):
    mp = KB(resize_keyboard=True)
    if m.text.split()[0]=='Включить':
        tg_db.set_notification(m.from_user.id,False)
        mp.add(KBB('Выключить уведомления'))
        await bot.send_message(m.from_user.id,'Уведомления включены',reply_markup=mp)
    elif m.text.split()[0]=='Выключить':
        tg_db.set_notification(m.from_user.id, True)
        mp.add(KBB('Включить уведомления'))
        await bot.send_message(m.from_user.id, 'Уведомления выключены', reply_markup=mp,disable_notification=True)

@dp.message_handler(commands=['admin'])
async def open_admin(m: M):
    await AdminPanel.enter.set()
    await bot.send_message(m.from_user.id, 'Введите пароль, пожалуйста.')

@dp.message_handler(commands=['notifications'])
async def change_notifiications(m:M):
    await bot.send_message(m.from_user.id, )

@dp.message_handler(state=AdminPanel.enter)
async def get_password(m: M, state: FSMContext):
    if m.text != config.TelegramBot.admin_password:
        await bot.send_message(m.from_user.id, f'Неверный пароль. Повторите попытку.')
        return
    await AdminPanel.next()
    mp = KB(resize_keyboard=True)
    mp.add(KBB('Поменять расписание'))
    mp.add(KBB('Выйти'))
    await bot.send_message(m.from_user.id, 'Добро пожаловать на панель админа.', reply_markup=mp)


@dp.message_handler(lambda m: m.text.startswith('Поменять'), state=AdminPanel.mainPanel)
async def get_schedule(m: M, state: FSMContext):
    await AdminPanel.next()
    await bot.send_message(m.from_user.id, 'Введите, с каким периодом рассылать сообщения(в днях).',
                           reply_markup=ReplyKeyboardRemove())


@dp.message_handler(state=AdminPanel.scheduleSettings)
async def set_schedule(m: M, state: FSMContext):
    if not m.text.isdigit():
        await bot.send_message(m.from_user.id, 'Неправильно введено время. Повторите попытку.')
        return
    config.update_schedule(int(int(m.text) * 86400))
    await AdminPanel.mainPanel.set()
    mp = KB(resize_keyboard=True)
    mp.add(KBB('Поменять расписание'))
    mp.add(KBB('Выйти'))
    await bot.send_message(m.from_user.id, 'Расписание изменено.', reply_markup=mp)


@dp.message_handler(lambda m: m.text.startswith('Выйти'), state=AdminPanel.mainPanel)
async def exit_from_admin_panel(m: M, state: FSMContext):
    await state.finish()
    await bot.send_message(m.from_user.id, 'Выход', reply_markup=ReplyKeyboardRemove())
    await bot.delete_message(m.from_user.id, m.message_id + 1)


async def periodic(sleep_for):
    while True:
        await asyncio.sleep(sleep_for)
        for i in util.get_message():
            print(i[0][0])
            await bot.send_message(i[0][0], i[1],disable_notification=i[0][1])


if __name__ == "__main__":
    loop = asyncio.get_event_loop()
    loop.create_task(periodic(config.TelegramBot.schedule))
    try:
        executor.start_polling(dp, loop=loop)
    except Exception as e:
        logger.error(e)
