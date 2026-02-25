package aula2;

// Personagem.java — Estrutura da classe base
public class Personagem {

    // protected = acessível nas subclasses (Heroi e Monstro)
    public String nome;
    public int vida;
    public int ataque;
    public int defesa;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int atacar() {
        int variacao = (int)(Math.random() * 8) - 2;
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vida -= danoReal;
        if(vida < 0) vida = 0;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }

    
}