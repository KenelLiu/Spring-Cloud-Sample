CREATE TABLE cloud_properties (
  id INTEGER NOT NULL AUTO_INCREMENT,
  CREATED_ON DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  APPLICATION VARCHAR (255),
  PROFILE VARCHAR (255),
  LABEL VARCHAR (255),
  PROP_KEY VARCHAR (255),
  VALUE VARCHAR (255),
  PRIMARY KEY (id)
) ;
INSERT INTO cloud_properties (APPLICATION, PROFILE, LABEL, PROP_KEY, VALUE) VALUES
('spring-cloud-config-client', 'dev', 'latest', 'URL_A', 'https://client-urlA-dev.com'),
('spring-cloud-config-client', 'dev', 'latest', 'URL_B', 'https://client-urlB-dev.com'),
('spring-cloud-config-client', 'test', 'latest', 'URL_A', 'https://client-urlA-test.com'),
('spring-cloud-config-client2', 'dev', 'latest', 'URL_A', 'https://client2-urlA-dev.com'),
('spring-cloud-config-client2', 'test', 'latest', 'URL_A', 'https://client2-urlA-test.com'),
('spring-cloud-config-client', 'sit', 'latest', 'URL_A', 'https://client-urlA-sit.com');
