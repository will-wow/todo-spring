INSERT IGNORE INTO user VALUES(10001, false, sysdate(), 'Alice');
INSERT IGNORE INTO user VALUES(10002, true, sysdate(), 'Bob');
INSERT IGNORE INTO user VALUES(10003, false, sysdate(), 'Cat');
INSERT IGNORE INTO post VALUES(11001, 'First!', 10001);
INSERT IGNORE INTO post VALUES(11002, 'Second!', 10001);
