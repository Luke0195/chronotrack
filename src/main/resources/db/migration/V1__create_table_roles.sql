CREATE TABLE tb_roles(
  id BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(45) NOT NULL UNIQUE,
  created_at TIMESTAMP WITHOUT TIME ZONE,
  updated_at TIMESTAMP WITHOUT TIME ZONE
);

INSERT INTO tb_roles(id, name, created_at) VALUES(1, 'user', NOW());
INSERT INTO tb_roles(id, name, created_at) VALUES(2, 'admin', NOW());
