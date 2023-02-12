import java.io.*;

class Passo2{ 
	int size_array;
	int size_key;
	int count=0;
	char[] array;
	int key_start=0;
	int key_end=0;
	
	Passo2(char[] input){
		//definir o tamanho do array de chars que vamos analisar
		this.size_array= input.length;
		this.array = input;
		
		for (int i = 0; i < size_array; i++){ //percorrer a String
            if(Character.isLetter(input[i]))
            	this.array[i] = input[i]; //transformar a String num vetor de chars
            else{
            	array[i]= ' ';
            	count++;
            }
		}
		if(count==size_array){
			System.out.println("A string n�o tem caracteres v�lidos");
			return;
		}
	}
	
	void find_key(int hint, int copy){
		int aux=0;
		int key_start_aux=hint;
		for(int i=1; hint<size_array-1 && copy<size_array-1; i++){
			hint++;
			copy++;
			if(array[hint]==array[copy])
				aux=i;
			else
				break;
		}
		if(aux>key_end-key_start){
			key_end=hint;
			key_start=key_start_aux;
		}
		
	}
	
	void detetor(){
	
		for(int i=0; i<size_array-1; i++)
			for(int j=i+1; j<size_array-1;j++)
				if(array[i]==array[j] && array[i]!=' ')
					find_key(i,j);
		
		size_key=key_end-key_start;
		
		if(size_key==0){
			System.out.println("N�o existem caracteres iguais na string.");
			return;
		}		
		
		System.out.println("O comprimento da substring � "+size_key+ "");
		System.out.println("A maior repeti��o que verificou-se na string foi: ");
		for(int i=key_start; i!=key_end; i++)
			System.out.print(array[i]);
		System.out.println();
		
	}
	
	public static void main(String[] args) throws IOException {
     
        try {
            File fx = null;
            InputStream istream = null;
            fx = new File(args[0]);
            istream = new FileInputStream(fx);
            
            Reader reader = new InputStreamReader(istream);
            //ou Reader reader = new InputStreamReader (System.in); - para ler do  input com o ficheiro redireccionado � < texto.txt
            
            char[] input= new char[istream.available()];
            reader.read(input);
            reader.close();
            
            Passo2 test= new Passo2(input);
            test.detetor();
    		
    		istream.close();
   	
        }
        
        catch (IOException e) {
            System.out.println("Oops");
        }
	}
}
