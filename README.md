# assembly-mipinho
Interpretador de instruções Assembly MIPS em alto nível desenvolvido
em Java para o projeto final da disciplina de Fundamentos de Sistemas de Computação,
do Mestrado Profissional em Engenharia de Software IMD/UFRN 2016.1.

##############################
Detalhamento do projeto:

* res/ -> Arquivos .asm

PACKAGES: assembly.mips.simulator
MAIN:  -->> .interpreter <<--

* .address
  - IPHandler              -> Armazena os endereços IPs das máquinas;

* .code
  - Data                   -> Simulação alto nível de um Data Segment;
  - Instruction            -> Simulação alto nível de uma instrução;
  - Label                  -> Simulação alto nível de um label;
  - MipinhoReader          -> Leitor de código Assembly MIPS (organiza os labels e instruções);

* .hardware
  - DataRegisters          -> Hash e manipulador de Data Segment;
  - InstructionRegisters   -> Hash e manipulador de instruções;
  - LabelRegisters         -> Hash e manipulador de Labels;
  - Register               -> Simulador alto nível de um registro ($s1, $s2);
  - Registers              -> Hash e manipulador de registros;

* .instruction
  - InstructionHandler     -> Recebe a solicitação de cada instrução e designa a tarefa para a classe correta;
  - ParamHandler           -> Trata e retorna os parametros para que as instruções possam executar;
  - PRINT                  -> Exibi o calor contido em um registrador (PRINT $s1);
  - (AS OUTRAS CLASSES REPRESENTAM INSTRUÇÕES ASSEMBLY MIPS);

* .interpreter
  - MipinhoInterpreter     -> Faz a manipulação das instruções, e solicita a execução das mesmas;

* .socket
  - MipinhoSocket          -> Manipulador de Sockets;
