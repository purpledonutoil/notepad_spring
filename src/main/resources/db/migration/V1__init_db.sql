CREATE TABLE note (
    ID IDENTITY PRIMARY KEY,
    title VARCHAR(1000) NOT NULL CHECK (LENGTH(title) >= 1 AND LENGTH(title) <= 1000),
    content VARCHAR(1000) NOT NULL CHECK (LENGTH(content) >= 1 AND LENGTH(content) <= 1000)
);