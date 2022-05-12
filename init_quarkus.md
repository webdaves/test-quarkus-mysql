# Criação de Projeto com Quarkus

## Instalação do Quarkus

Executar comando:
```bash
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
```

> Se execução der erro, verifique arquivo `C:/Users/${USER}/.jbang/bin/jbang` e na linha 230 coloque o comando `${JAVA_EXEC}` entre aspas -> `"${JAVA_EXEC}"`. Salve e execute novamente

## Criação do projeto

Crie um novo projeto QUarkus com o comando:
```
quarkus create app org.projeto:reactive-mysql-client --extension=resteasy-reactive,reactive-mysql-client --no-code
cd reactive-mysql-client
```

Instale a extensão:
```
quarkus extension add resteasy-reactive-jackson
```

Inclua o Lombok diretamente no `pom.xml`

```
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.18.24</version>
	<scope>provided</scope>
</dependency>
```

Configure a extensão do Lombok na IDE:
- [Eclipse](https://projectlombok.org/setup/eclipse)
- [VSCode](https://projectlombok.org/setup/vscode)
- [IntelliJ](https://projectlombok.org/setup/intellij)

Inclua as configurações do banco em `src/main/resources/application.properties`:

```
quarkus.datasource.db-kind=mysql
quarkus.datasource.username=quarkus_test
quarkus.datasource.password=quarkus_test
quarkus.datasource.reactive.url=mysql://localhost:5432/quarkus_test
```
