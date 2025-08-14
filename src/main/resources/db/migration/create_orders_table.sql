CREATE TABLE IF NOT EXISTS smarkov.orders
(
    id          UUID PRIMARY KEY,
    weight      INT,
    ordered_for VARCHAR(255),
    baked_at    TIMESTAMP
);
