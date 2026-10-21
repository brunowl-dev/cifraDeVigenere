### Cifra de Vigenère

Aplicação desktop em **Java**, com interface gráfica em **Swing**, para criptografar mensagens utilizando a Cifra de Vigenère.

A cifra utiliza uma palavra-chave para definir os deslocamentos aplicados às letras da mensagem, permitindo explorar o funcionamento de uma técnica clássica de criptografia polialfabética.

> **Projeto em desenvolvimento:** ainda faltam prevenção e tratamento de erros, a função de descriptografar e a geração de um executável `.exe` para Windows.

#### Funcionalidades implementadas

- Interface gráfica com campos para mensagem e chave.
- Criptografia de mensagens utilizando a Cifra de Vigenère.
- Conversão automática da mensagem e da chave para letras maiúsculas.
- Remoção de espaços em branco antes da criptografia.
- Repetição da chave quando necessário para acompanhar o tamanho da mensagem.
- Exibição do resultado na própria interface.

#### Tecnologias utilizadas

- **Java** — implementação da aplicação e da lógica de criptografia.
- **Swing** — componentes da interface gráfica.
- **AWT** — recursos de interface e tratamento de eventos.

As classes atuais utilizam apenas bibliotecas padrão do Java, sem dependências externas.

#### Organização do projeto

| Caminho | Responsabilidade |
|---|---|
| `src/business/Chave.java` | Armazena a chave e a repete para acompanhar o tamanho da mensagem. |
| `src/business/Criptografar.java` | Prepara as entradas e realiza a criptografia. |
| `src/view/Formulario.java` | Cria a interface gráfica e conecta o botão à operação de criptografia. |
| `src/view/Principal.java` | Contém o método `main`, responsável por iniciar a aplicação. |
| `.vscode/` | Configurações do ambiente de desenvolvimento no Visual Studio Code. |

#### Como executar

**Pré-requisitos:**

- JDK instalado, com os comandos `java` e `javac` disponíveis no terminal.
- Ambiente com suporte a interface gráfica.

**Pela IDE:**

1. Clone ou baixe o [repositório](https://github.com/brunowl-dev/cifraDeVigenere).
2. Abra a pasta do projeto em uma IDE com suporte a Java.
3. Configure o JDK, caso necessário.
4. Execute o método `main` da classe `src/view/Principal.java`.

**Pelo terminal:**

Na pasta raiz do projeto, compile as classes:

```bash
javac -encoding UTF-8 -d bin src/business/Chave.java src/business/Criptografar.java src/view/Formulario.java src/view/Principal.java
```

Em seguida, inicie a aplicação:

```bash
java -cp bin view.Principal
```

Esses comandos compilam o código para classes Java e iniciam a interface; **não geram um arquivo `.exe`**.

#### Como utilizar

1. Digite o texto no campo **Mensagem**.
2. Informe uma palavra-chave no campo **Chave**.
3. Clique em **CRIPTOGRAFAR**.
4. Consulte o texto cifrado ao lado de **Resultado**.

**Cuidados na versão atual:**

- Utilize somente letras de **A a Z**, sem acentos, números ou pontuação.
- Não deixe a mensagem ou a chave vazias.
- Espaços em branco são removidos durante o processamento.

Essas orientações são necessárias porque a aplicação ainda não impede entradas inválidas nem apresenta mensagens de erro para esses casos.

#### Limitações e pendências

**1. Prevenção e tratamento de erros**

Ainda falta implementar validações e tratamento de exceções, incluindo:

- Verificação de mensagem e chave vazias.
- Validação dos caracteres permitidos.
- Verificação do tamanho da chave após a remoção dos espaços.
- Exibição de mensagens claras quando uma entrada for inválida.

Atualmente, entradas inadequadas podem provocar exceções ou produzir resultados incorretos.

**2. Função de descriptografar**

A aplicação realiza apenas a criptografia. Ainda falta implementar a operação inversa para recuperar a mensagem a partir do texto cifrado e da chave correspondente.

**3. Compilação e distribuição em `.exe`**

Ainda falta configurar a geração e distribuição de um executável `.exe` para Windows. No estado atual, a aplicação deve ser compilada e executada pelo ambiente Java.

#### Próximas implementações

- [x] Implementar prevenção e tratamento de erros.
- [x] Validar mensagem e chave antes da criptografia.
- [x] Adicionar a função de descriptografar.
- [x] Incluir a opção de descriptografia na interface.
- [ ] Configurar a geração de um executável `.exe` para Windows.

#### Aviso sobre segurança

A Cifra de Vigenère é uma técnica clássica de criptografia e não oferece segurança adequada para proteger informações sensíveis atualmente. Esta aplicação deve ser utilizada para demonstração e estudo do algoritmo, não para proteção de dados reais.
