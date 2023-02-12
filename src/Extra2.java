import java.io.*;

//Bibiana Farinha 98416
//Nicole Nunes 98686
//LEI 1� Ano

class Extra2 { //algoritmo de for�a bruta 

	int size_array1; //tamanho do array do primeiro argumento
	char[] input1; // primeiro argumento
	
	int size_array2; //tamanho do array do segundo argumento
	char[] input2; // segundo argumento
	
	int key_start=0;
	int key_end=0;
	int size_key=0;
	
	Extra2(char[] a, char[] b){
		//tratar do primeiro input
		size_array1= a.length;
		input1 = new char[size_array1];
		
		for (int i = 0; i < size_array1; i++){ //percorrer o primeiro argumento e filtra-lo
            if(Character.isLetter(a[i]))
            	input1[i] = a[i]; 
            else{
            	input1[i]= ' ';
            }
		}
		
		//tratar do segundo input
		size_array2= b.length;
		input2 = new char[size_array2];
		
		for (int i = 0; i < size_array2; i++){ //percorrer o segundo argumento e filtra-lo
            if(Character.isLetter(b[i]))
            	input2[i] = b[i]; 
            else{
            	input2[i]= ' ';
            }
		}
	}
	
	void find_key(int i1, int i2){
		int aux=0;
		int key_start_aux=i1;
		for(int i=1; i1<size_array1-1 && i2<size_array2-1; i++){
			i1++;
			i2++;
			if(input1[i1]==input2[i2])
				aux=i;
			else
				break;
		}
		if(aux>key_end-key_start){
			key_end=i1;
			key_start=key_start_aux;
		}
	}
	
	void detetor(){
		for(int i=0; i<size_array1-1; i++)
			for(int j=0; j<size_array2-1;j++)
				if(input1[i]==input2[j])
					find_key(i,j);
			
		size_key=key_end-key_start;
		
		if(size_key==0){
			System.out.println("N�o existem caracteres iguais na string.");
			return;
		}		
		
		System.out.println("O comprimento da substring � "+size_key+ "");
		System.out.println("A maior repeti��o que verificou-se na string foi: ");
		for(int i=key_start; i!=key_end; i++)
				System.out.print(input1[i]);
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		
        try {
        	File fx = null;
	        InputStream istream = null;
	        fx = new File(args[0]);
	        istream = new FileInputStream(fx);
	        
	        File fx1 = null;
	        InputStream istream1 = null;
	        fx1 = new File(args[1]);
	        istream1 = new FileInputStream(fx1);
	        
            Reader reader = new InputStreamReader(istream);
            Reader reader1 = new InputStreamReader(istream1);
            
            char[] input= new char[istream.available()];
            reader.read(input);
            reader.close();
            
            char[] input1= new char[istream1.available()];
            reader1.read(input1);
            reader1.close();
            
            istream.close();
            istream1.close();
            
            Extra2 test= new Extra2(input, input1);
            test.detetor();
    		
        }
        
        catch (IOException e) {
            System.out.println("Oops");
        }
	}
}