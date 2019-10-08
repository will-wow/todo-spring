# Todo-Spring

A Todo App to learn Spring Boot

## Development

### Run 

```bash
mvn spring-boot:run
```

#### Setup DB

**Install MySQL**

```bash
brew install mysql
brew services start mysql
# or
sudo apt install mysql
```

**Set up MySQL**

```bash
mysql_secure_installation
```

**Create DB**

```bash
sudo mysql --password
create database todo_spring_dev;
create user 'springuser'@'%' identified by 'password';
grant all on todo_spring_dev.* to 'springuser'@'%';
\q
```

**Connect to DB**

```bash
mysql -u springuser --password --database todo_spring_dev
```

**Seed DB**

(there's probably a better way, `data.sql` is really for in-memory DBs)

```bash
mysql -u springuser --password --database todo_spring_dev < src/main/resources/data.sql
```
