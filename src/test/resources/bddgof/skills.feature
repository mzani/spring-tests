# language: pt
@alunos
Funcionalidade:  Alunos
  Consulta um aluno
  @testa_alunos
    Esquema do Cenario: Secretaria cadastra um aluno
      Dado Que Secretaria cadastra um aluno
      Quando Escolhe a opcao de consultar: <id aluno>
      E clica em consultar aluno:
      Entao A consulta deve retornar o aluno cadastrado: <resultado esperado>
      Exemplos:
          | id aluno | resultado esperado                                                                               |
          | "1"      | "AARON FELIPE GRASSMANN"      |
    