<div align="center">
   <image src="https://github.com/user-attachments/assets/d6da4449-59cc-4ebb-9a41-f92c5d615e8f" />
</div>

<p align="center">
   <img src="http://img.shields.io/static/v1?label=React&message=FRAMEWORK&color=blue&style=for-the-badge" #vitrinedev/>
   <img src="http://img.shields.io/static/v1?label=Java&message=17.0.5&color=red&style=for-the-badge" #vitrinedev/>
   <img src="http://img.shields.io/static/v1?label=Srping%20Boot&message=FRAMEWORK&color=green&style=for-the-badge" #vitrinedev/>
   <img src="http://img.shields.io/static/v1?label=license&message=MIT&color=yellow&style=for-the-badge" #vitrinedev/>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=greeb&style=for-the-badge" #vitrinedev/>
</p>

## <img height="30px" src="https://img.icons8.com/plasticine/100/null/todo-list.png"/> Tópicos
- [Descrição](#-descrição)
- [Funcionalidades](#-funcionalidades)
- [Layout](#-layout-ou-deploy-da-aplicação)
- [Ferramentas Utilizadas](#-ferramentas-utilizadas)
- [Pré Requisitos](#-pré-requisitos)
- [Executar / Testar](#-executar--testar)
- [Licença](#-licença)

## 📜 Changelog
Para conferir todas as mudanças e atualizações do projeto, acesse o [CHANGELOG.md](https://github.com/ygorfsguilherme/ui-blog-server/blob/main/CHANGELOG.md).


## <img src="https://cdn-icons-png.flaticon.com/512/3534/3534033.png" style="widht:30px; height:30px;" /> Descrição

UI Blog criado com o objetivo de documentar e compartilhar conhecimentos adquiridos ao longo da jornada no desenvolvimento de software. O blog serve como um espaço para registrar conceitos, práticas, dicas e desafios encontrados durante os estudos e projetos, abordando diversas tecnologias, linguagens de programação e ferramentas.

### Objetivos com a ferramenta:
- Registrar aprendizados e insights obtidos durante estudos e práticas de desenvolvimento.
- Compartilhar conhecimento com outros desenvolvedores e entusiastas da área.
- Facilitar a revisão e reforço de conceitos ao longo do tempo.

Este é apenas uma parte do desenvolvimento da aplicação. Para mais informações, acesse o repositório principal [aqui](https://github.com/ygorfsguilherme/ui-blog).

## <img height="35px" src="https://img.icons8.com/color/96/null/puzzle-matching.png"/> Funcionalidades
- Login e Cadastra
- Mostrar todas as postagem ao publico
- É possivel editar, criar e deleta postagem

## <img src="https://cdn-icons-png.flaticon.com/512/1835/1835211.png" style="widht:30px; height:30px;" /> Ferramentas Utilizadas
- <img height="20px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" /> Java
- <img height="20px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" /> Spring boot

Outras tecnologias como, banco de dados H2, spring security e jwt

## <img height="35px" src="https://img.icons8.com/fluency/96/null/requirement.png"/> Pré-requisitos
- [Java 17.xx](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.htmlnode)

## <img src="https://cdn-icons-png.flaticon.com/512/3068/3068553.png" style="widht:30px; height:30px;" /> Executar / Testar

Para começar, clone o projeto executando o seguinte comando no terminal:  

> No terminal, clone o projeto:
```
git clone https://github.com/ygorfsguilherme/ui-blog-server.git
```

Certifique-se de ter o Java 17.x instalado, pois é necessário para o funcionamento correto da aplicação.

> Entre no diretorio principal:

```
cd ui-blog-server
```
> Executar em modo desenvolvidor/teste:

```
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📌 Endpoint
### Todos os endpoint relacionado as tags

<details>
  <summary>Adiciona uma nova tag ao sistema.</summary>

  > Método: ```POST```
  - URL exemplo: http://exemplo.com.br/tag/

### Exemplo de Requisição (Body)
```json
{
    "name": "HTML"
}
```
### Resposta de Sucesso (201 Created)
```json
{
    "id": "72f517f4-8b62-4afb-b05f-a6fd33eff570",
    "name": "HTML"
}
```

### Erro: Tag já cadastrada (409 Conflict)
```json
{
    "message": "Tag já cadastrada",
    "error": null,
    "status": 409,
    "timestamp": "2025-02-22T14:11:20.284689424"
}
```

</details>

<details>
  <summary>Listar todas as tags cadastrada no sistema.</summary>

  > Método: ```GET```
  - URL exemplo: http://exemplo.com.br/tag/

### Resposta de Sucesso (200 Success)
```json
[
    {
        "id": "72f517f4-8b62-4afb-b05f-a6fd33eff570",
        "name": "HTML"
    }
]
```

</details>

### Todos os endpoint relacionado ao post.

<details>
  <summary>Criar uma nova postagem no sistema.</summary>

  > Método: ```POST```
  - URL exemplo: http://exemplo.com.br/post/

  ### Exemplo de Requisição (Body)
  ```json
  {
      "title": "Hello World",
      "content": "<h1>Hello, World!</h1>",
      "tags": ["72f517f4-8b62-4afb-b05f-a6fd33eff570"]
  }
  ```

  ### Resposta de Sucesso (201 Created)
  ```json
  {
      "id": "9f0c460e-69bb-4359-a48c-3495a34a3232",
      "title": "Hello World",
      "content": "<h1>Hello, World!</h1>",
      "tags": [
          {
              "id": "72f517f4-8b62-4afb-b05f-a6fd33eff570",
              "name": "HTML"
          }
      ],
      "createdAt": "2025-02-22T14:40:00.724114299",
      "updatedAt": "2025-02-22T14:40:00.724114299"
  }
  ```
</details>

<details>
  <summary>Atualizar a postagem no sistema.</summary>

  > Método: ```PUT```
  - URL exemplo: http://exemplo.com.br/post/
</details>

<details>
  <summary>Publica a postagem.</summary>

  > Método: ```PATCH```
  - URL exemplo: http://exemplo.com.br/post/publish/{id}/
</details>

<details>
  <summary>Lista todas as postagens</summary>

  > Método: ```GET```
  - URL exemplo: http://exemplo.com.br/post/
</details>

<details>
  <summary>Lista todas as postagens publicadas</summary>

  > Método: ```GET```
  - URL exemplo: http://exemplo.com.br/post/published/
</details>

<details>
  <summary>Lista todas as postagens não publicadas</summary>

  > Método: ```GET```
  - URL exemplo: http://exemplo.com.br/post/unpublished
</details>

## <img height="30px" src="https://img.icons8.com/external-filled-outline-icons-maxicons/85/null/external-balance-law-and-justice-filled-outline-filled-outline-icons-maxicons.png"/> Licença

UI Blog é licenciado pelo [MIT License](https://github.com/ygorfsguilherme/ui-blog/blob/main/LICENSE).