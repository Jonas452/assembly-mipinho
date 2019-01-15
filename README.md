# assembly-mipinho
High level interpreter of Assembly MIPS instructions developed in Java for a project at the university.

##############################
Project details:

* res/ -> Files .asm

PACKAGES: assembly.mips.simulator
MAIN:  -->> .interpreter <<--

* .address
  - IPHandler              -> Stores the IP addrress of the machines;

* .code
  - Data                   -> High level simulator of a Data Segment;
  - Instruction            -> High level simulator of an instruction;
  - Label                  -> High level simulator of a label;
  - MipinhoReader          -> Assembly MIPS code reader (manage the labels and instructions);

* .hardware
  - DataRegisters          -> Hash and manipulator of the Data Segment;
  - InstructionRegisters   -> Hash and manipulator of the instructions;
  - LabelRegisters         -> Hash and manipulator of the Labels;
  - Register               -> High level simulator of a register ($s1, $s2);
  - Registers              -> Hash and manipulator of the registers;

* .instruction
  - InstructionHandler     -> Handle the instructions and instanciate the apropriate class;
  - ParamHandler           -> Handle and return the parameters so the instructions can be executed;
  - PRINT                  -> Prints a value of a register (PRINT $s1);
  - (THE OTHER CLASSES ARE Assembly MIPS instructions);

* .interpreter
  - MipinhoInterpreter     -> Manipulate the instructions, and executes the instructions;

* .socket
  - MipinhoSocket          -> Sockets manipulator;
