	.data
	
VetorA: .word 0,0,0,0,0,0
MatrizB: .word 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0, 0,0,0,0,0,0
VetorC: .word 0,0,0,0,0,0
	.text
	.globl main
	
main:	
       
    #o registrador $s0 guarda o id do raspberry. Modifique o código de acordo com o escravo
    li $s0, 0
    
	#$s1 recebe o número de raspberrys escravos
    li $s1, 6
        
	#$t0 guarda o endereço de memória do segundo parametro. Nesse caso, "VetorA"
    la $t0, VetorA
		
    #$t1 guarda o endereço de memória do segundo parametro. Nesse caso, "MatrizB"
    la $t1, MatrizB
		
    #$t2 guarda o endereço de memória do segundo parametro. Nesse caso, "VetorC"
    la $t2, VetorC        
        
	#recebe a linha correspondente da Matriz A 
recebeA:
	rcv $s3, 24, $t0

	#recebe todas as linhas da Matriz B		
recebeB:
	rcv $s3, 144, $t1

	#contador de elementos da coluna
	li $a0, 0
	
	#contador de colunas
	li $s2, 0
	
	#numero total de elementos
	li $a1, 6
	
	#numero total de colunas
	li $s3, 6
	
	#registrador auxiliar que armazena o valor do elemento a ser inserido no VetorC resultante
	li $t4, 0
	
	#$t3 aponta para o proximo elemento da MatrizB a ser utilizado no cálculo
    addi $t3, $t1, 0
	
	#$t4 aponta para o proximo elemento do VetorA a ser utilizado no cálculo
    addi $t4, $t0, 0


    #guarda o endereço inicial da coluna. isso vai facilitar a passagem para a próxima coluna
proxCol:  
	addi $t5, $t3, 0
	
soma:   
	#lê o proximo elemento da n-ésima coluna da Matriz B
	lw $a2, 0($t3)
	
	#lê o proximo elemento do vetor VetorA recebido
	lw $a3, 0($t4)
	
	#realiza a multiplicação dos elementos correspondentes na coluna da MatrizB e no vetorA
	mult $t6, $a2, $a3

	#carrega o valor atual do elemento que estamos calculando.
	lw $a2, 0($t2)
	
	#acumula o valor do elemento
	add $a2, $t6, $a2
	
	#escreve o valor atual do elemento que estamos calculando.
	sw $a2, 0($t2)
	
	#incrementa o contador de elementos
	addi $a0, $a0, 1
	
	#avanca para o proximo elemento na coluna: 6elementos x 4bytes
	addi $t3, $t3, 24
	
	#avança para o proximo elemento do VetorA
	addi $t4, $t4, 4
	
	#verifica se este é o ultimo elemento da coluna
	bne $a0, $a1, soma
	
	#se terminou a coluna
	#reinicializa o contador
	li $a0, 0
	
	#volta para o primeiro elemento do vetorA
	addi $t4, $t0, 0
	
	#passa para o primeiro elemento da próxima coluna
	addi $t3, $t5, 4 
	
	#incrementa o endereço do vetorC
	addi $t2, $t2, 4
	
	#incrementa o número de colunas já processadas
	addi $s2, $s2, 1
	
	#verifica se já processou todas as colunas
	bne $s2, $s3, proxCol	
	
	#se já processou todas as colunas              
    #envia o vetorC                
enviaA: 
	snd $s0, 24, $t2

    #terminou o envio do VetorC para o mestre.



