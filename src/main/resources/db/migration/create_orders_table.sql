CREATE SCHEMA IF NOT EXISTS smarkov;

CREATE TABLE IF NOT EXISTS smarkov.orders
(
    id          UUID PRIMARY KEY,
    weight      INT,
    ordered_for VARCHAR(255),
    baked_at    TIMESTAMP
);

CREATE TABLE IF NOT EXISTS smarkov.pie
(
    weight      INTEGER,
    ordered_for TEXT
);
