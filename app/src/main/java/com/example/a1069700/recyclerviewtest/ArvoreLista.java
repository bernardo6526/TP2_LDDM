package com.example.a1069700.recyclerviewtest;
import java.util.ArrayList;
import java.util.Iterator;

class ArvoreLista {

    public int n;
    public No raiz;

    ArvoreLista(){
        this.n = 1;
        this.raiz = new No(null,"raiz",false);
    }

    void inserir (String pai, String conteudo){
        No nPai = buscar(pai);
        inserir(nPai,conteudo);
    }

    void inserir(No pai, String conteudo){
        No filho = new No(pai,conteudo, true);
        pai.filhos.add(filho);
        pai.folha = false;
        n++;
    }

    void alterar(String atual, String novo){
        No no = buscar(atual);
        no.conteudo = novo;
    }

    void remover(String conteudo){
        No no = buscar(conteudo);
        remover(no.pai,no);
    }

    void remover(No pai, No filho){
        Iterator itr = pai.filhos.iterator();
        while (itr.hasNext())
        {
            No x = (No)itr.next();
            if (x == filho)
                itr.remove();
        }
        if(pai.filhos.size() == 0)pai.folha = true;
        n--;
    }

    No buscar(String conteudo){
        return buscar(raiz,conteudo,0,null);
    }

    No buscar(No no,String conteudo, int i, No filho){
        if(i < n){
            if(conteudo.equals(no.conteudo)){
                filho = no;
            }else{
                if(!no.folha){
                    Iterator itr = no.filhos.iterator();
                    while (itr.hasNext())
                    {
                        No x = (No)itr.next();
                        filho = buscar(x,conteudo,i+1,filho);

                    }
                }
            }
        }
        return filho;
    }


    void mostrar(){
        buscar(raiz,0);
    }

    No buscar(No no,int i){
        if(i < n){
            System.out.println(no.conteudo);
            if(!no.folha){
                Iterator itr = no.filhos.iterator();
                while (itr.hasNext())
                {
                    No x = (No)itr.next();
                    buscar(x,i+1);

                }
            }
        }

        return no;
    }
}

class No{
    public No pai;
    public String conteudo;
    public boolean folha;
    public ArrayList<No> filhos = new ArrayList<No>();

    No(No pai,String conteudo,boolean folha){
        this.pai = pai;
        this.conteudo = conteudo;
        this.folha = folha;
    }

}