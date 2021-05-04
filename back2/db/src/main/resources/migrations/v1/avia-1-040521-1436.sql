

CREATE TABLE recent_city
(
recent_city_id SERIAL PRIMARY KEY,
recent_city_id_city INTEGER,
recent_city_user_id INTEGER

);

CREATE TABLE recent_flights
(
recent_flights_id SERIAL PRIMARY KEY,
recent_flights_id_flight INTEGER,
recent_flights_user_id INTEGER

);
CREATE TABLE user_purchase
(
user_purchase_id SERIAL PRIMARY KEY,
user_purchase_id_flight INTEGER,
user_purchase_user_id INTEGER,
user_purchase_count INTEGER,
user_purchase_flight_cost INTEGER,
user_purchase_date DATE
);
CREATE TABLE favorite_flights
(
favorite_flights_id SERIAL PRIMARY KEY,
favorite_flights_id_flight INTEGER,
favorite_flights_user_id INTEGER ,
UNIQUE (favorite_flights_id_flight,favorite_flights_user_id)
);
