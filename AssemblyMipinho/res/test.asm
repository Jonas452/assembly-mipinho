MatrizA: .word 1,2,3,4,5,6, 7,8,9,10,11,12, 13,14,15,16,17,18, 19,20,21,22,23,24, 25,26,27,28,29,30, 31,32,33,34,35,36
MatrizB: .word 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2, 2,2,2,2,2,2
MatrizC: .word 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0
Aux:    .word 0,0,0,0,0,0
		.text
		.globl main
		
main:	
        #enviar as linhas corretas da matriz A
        #o registrador $s0 guarda o id do raspberry que vai receber a linha correspondente ao seu id
        #id=0 recebe a linha 0, id=1 recebe a linha 1, etc...
        li $s0, 0
		
        #$s1 recebe o número de raspberrys escravos
        li $s1, 6
		
        #aqui, $s2 é um contador de respostas. Assim que o mestre receber 6 respostas dos 6 escravos, o algoritmo termina
		li $s2, 0
	
        #$t0 guarda o endereço de memória do segundo parametro. Nesse caso, "MatrizA"
        la $t0, MatrizA
		
        #$t1 guarda o endereço de memória do segundo parametro. Nesse caso, "MatrizB"
        la $t1, MatrizB
		
        #$t2 guarda o endereço de memória do segundo parametro. Nesse caso, "MatrizC"
        la $t2, MatrizC  
		
        #$t3 guarda o endereço de memória do segundo parametro. Nesse caso, "Aux"
        la $t3, Aux          
        
enviaA: 
	snd $s0, 24, $t0
    addi $s0, $s0, 1
    bne $s0, $s1, enviaA

	li $s0, 0
		
enviaB: 
	snd $s0, 144, $t1
    addi $s0, $s0, 1
    bne $s0, $s1, enviaB
        

recebeC: 
	rcv $s3, 24, $t3