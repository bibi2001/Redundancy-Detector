import java.io.*;

//Bibiana Farinha 98416
//Nicole Nunes 98686
//LEI 1� Ano

class Passo1 { //algoritmo de for�a bruta 
	int size_array;
	int key_next=0;
	int biggest_next=0;
	int count=0;
	char[] array;
	char[] key;
	
	Passo1(char[] input){
		//definir o tamanho do array de chars que vamos analisar
		this.size_array= input.length;
		this.array = input;
		key = new char[size_array];
		
		for (int i = 0; i < size_array; i++){ //percorrer a String
            if(Character.isLetter(input[i]))
            	this.array[i] = input[i]; //transformar a String num vetor de chars
            else{
            	array[i]= ' ';
            	count++;
            }
		}
	}
	
	void find_key(int hint, int copy){
		char[] aux_key= new char[size_array];
		key_next=1;
		aux_key[0]=array[hint];
		copy++;
		for(int i=hint+1; i<size_array-1 && copy<size_array; i++){
			if(array[i]==array[copy]){
				aux_key[key_next]=array[i];
				key_next++;
				copy++;
			}else
				break;
		}
		key=aux_key;
	}
	
	char[] detetor(){
		char[] biggest_key=key;
		for(int i=0; i<size_array-1; i++)
			for(int j=i+1; j<size_array-1;j++){
				if(array[i]==array[j] && array[i]!=' ')
					find_key(i,j);
				if(biggest_next<key_next){
					biggest_key=key;
					biggest_next=key_next;
				}
				if(biggest_next==key.length)
					return biggest_key;
			}
		return biggest_key;
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
            
            Passo1 test= new Passo1(input);
            char[] key = test.detetor();
    		int size_key=test.biggest_next;
    		
    		istream.close();
    		
    		if(test.count==test.size_array){
    			System.out.println("A string n�o tem caracteres v�lidos");
    			return;
    		}
    		
    		if(size_key==0){
    			System.out.println("N�o existem caracteres iguais na string.");
    			return;
    		}
    			
    		System.out.println("O comprimento da substring � "+size_key+ "");
    		System.out.println("A maior repeti��o que verificou-se na string foi: ");
    		for(int i=0; i!=size_key; i++)
    			System.out.print(key[i]);
    		System.out.println();
    		
        }
        
        catch (IOException e) {
            System.out.println("Oops");
        }
	}
}