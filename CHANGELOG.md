# Changelog

Todas as mudanças notáveis neste projeto serão documentadas aqui.

O formato segue as convenções de [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) e este projeto segue a versão [SemVer](https://semver.org/lang/pt-BR/).

## [Unreleased]

## [0.3.0] - 2025-02-19
### Adicionado
- Exibição de postagens publicadas para visitantes sem necessidade de autenticação.
- Exibição de postagens não publicadas para administradores.
- DTO `PostRequest` agora define automaticamente o título como `"Rascunho"` caso esteja vazio ou `null`.

## [0.2.0] - 2025-02-18
### Adicionado
- Recurso para exibir postagens em ordem da mais nova à mais antiga.

### Depreciado
- Marcado para remoção a classe `CreatePostResponse`.
- Marcado para remoção o método `getTitleFromDto` da classe `PostCreateService`.

## [0.1.0] - 2025-02-15
### Adicionado
- Adicionado recurso para criação de postagens, incluindo os campos `title`, `content`, `tags`, `createdAt`, `updatedAt`, `published` e `deleted`.
- Adicionado recurso de tags, endpoint criação e mostrar todas as tags.

## [0.0.0] - 2025-02-13
### Lançamento Inicial
- Estrutura inicial do projeto com Spring Boot.
- Implementação da estrutura básica para gerenciamento de postagens.
