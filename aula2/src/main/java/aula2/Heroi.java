package aula2;

import java.util.ArrayList; // Necessário para o Inventário

public class Heroi {

    private String nome;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int pocoes;
    
    // Atributos Novos
    private int xp;
    private int nivel = 1; 
    private ArrayList<Item> inventario = new ArrayList<>();

    public Heroi(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocoes = 3;
        this.xp = 0;
    }

    public String getNome() {return nome;}
    public int getVida()    { return vidaAtual; }
    public int getAtaque()  { return ataque; }
    public int getDefesa()  { return defesa; }
    public int getPocoes()  { return pocoes; }
    public int getXp()      { return xp; }
    public int getNivel()   { return nivel; }

    // INVENTÁRIO
    public void adicionarItem(Item item) {
        inventario.add(item);
        System.out.println("🎒 " + item.getNome() + " foi adicionado ao inventário.");
    }

    public void listarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("🎒 O inventário está vazio.");
        } else {
            System.out.println("\n--- 🎒 Inventário ---");
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println("[" + i + "] " + inventario.get(i).getDescricao());
            }
            System.out.println("---------------------");
        }
    }

    public boolean usarItem(int indice) {
        if (indice >= 0 && indice < inventario.size() && !inventario.isEmpty()) {
            Item item = inventario.get(indice);
            item.usar(this);
            inventario.remove(indice);
            return true;
        } else {
            System.out.println("❌ Índice inválido!");
            return false;
        }
    }

    // Métodos de Suporte para os Itens
    public void receberCura(int valor) {
        vidaAtual += valor;
        if (vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;
        System.out.println("💚 " + nome + " recuperou " + valor + " de vida! [" + vidaAtual + "/" + vidaMaxima + "]");
    }

    public void aumentarAtaque(int valor) {
        ataque += valor;
        System.out.println("⚔️ " + nome + " ganhou +" + valor + " de ataque! [Total: " + ataque + "]");
    }

    // --- MÉTODOS DE BATALHA E STATUS ---
    public int atacar() {
        int variacao = (int)(Math.random() * 10) - 5;
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vidaAtual -= danoReal;
        if(vidaAtual < 0) vidaAtual = 0;

        System.out.println(" 💔 " + nome + " recebeu " + danoReal + " de dano! "
        + "[❤️ " + vidaAtual + "/" + vidaMaxima + "]");
    }

    public boolean usarPocao() {
        if (pocoes <= 0) {
            System.out.println(" ❌ Sem poções!");
            return false;
        }
        if (vidaAtual == vidaMaxima){
            System.out.println(" ⚠️ Vida já está cheia! Poção não foi usada.");
            return false;
        }

        int cura = 30;
        vidaAtual += cura;
        if ( vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;

        pocoes--;
        System.out.println(" 🧪 " + nome + " usou poção! +30 💚 "
                + "[💚 " + vidaAtual + "/" + vidaMaxima + "] [Poções: " + pocoes + "]");
        return true;
    }

    // --- SISTEMA DE NÍVEIS (Atividade 03) ---
    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println(" ⭐ ⬆️ +" + quantidade + " XP! [Total: " + xp + "]");
        verificarNivel(); 
    }

    private void verificarNivel() {
        int xpNecessario = nivel * 100;
        if (xp >= xpNecessario) {
            nivel++;
            ataque += 5;
            defesa += 2;
            vidaMaxima += 20;
            vidaAtual += 20;
            if (vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;
            pocoes++;
            
            System.out.println("\n🌟 LEVEL UP!");
            System.out.println(nome + " chegou ao Nível " + nivel + "!");
            System.out.println("⚔️ Ataque +5 | 🛡️ Defesa +2 | ❤️ Vida +20\n");
        }
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void exibirStatus() {
        System.out.println("\n🦸‍♂️ " + nome);
        System.out.println(" 🌟 Nível: " + nivel); // Adicionado nível
        System.out.println(" ❤️ Vida: " + vidaAtual + "/" + vidaMaxima);
        System.out.println(" ⚔️ Ataque: " + ataque);
        System.out.println(" 🛡️ Defesa: " + defesa);
        System.out.println(" 🧪 Poções: " + pocoes);
        System.out.println(" ⭐ XP: " + xp);
    }
}