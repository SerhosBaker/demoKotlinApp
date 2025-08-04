# demoKotlinApp
My demo app to study kotlin

В качестве БД на данный момент используется экземпляр тестовой БД Образования. Однако выделил в нем отдельную схему smarkov.

```sql
create table smarkov.pie
(
    weight      integer,
    ordered_for text
);

alter table smarkov.pie
    owner to liquibase;

INSERT INTO smarkov.pie (weight, ordered_for)
SELECT
    (RANDOM() * 1199 + 1)::INT,
    (ARRAY['Serhos', 'Ulrich', 'Ed', 'Yar', 'Sofa', 'Sonne'])[FLOOR(RANDOM() * 6) + 1]
FROM GENERATE_SERIES(1, 100);
```
