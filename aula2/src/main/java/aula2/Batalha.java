package aula2;

import java.util.Scanner;

public class Batalha {
    
    private Heroi heroi;
    private Monstro monstro;
    private Scanner scanner;

    public Batalha(Heroi heroi, Monstro monstro , Scanner scanner) {
        this.heroi = heroi;
        this.monstro = monstro;
        this.scanner = scanner;
    }

    public boolean iniciar() { 
        exibirCabecahoBatalha();

        int turno = 1;
        
        while ((heroi.estaVivo() && monstro.estaVivo())) {
            System.out.println("\n=========== Turno " + turno + " ========");
            exibirStatusBatalha();

            turnoHeroi(); 
            if (monstro.estaVivo()) {
                turnoMonstro(); 
            }
            turno++;
        }

        return resolverFinal();
    }

    private void turnoHeroi() {
        System.out.println("\n\n O que " + heroi.getNome() + " vai fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Usar Poção (" + heroi.getPocoes() + " restantes)");
        System.out.println("3. Abrir Inventário"); // Nova Opção
        System.out.print("Opção: ");

        int escolha = lerEscolha();

        switch (escolha) {
            case 1:
                int dano = heroi.atacar();
                System.out.println(" Você atacou " + monstro.getNome() + " causando " + dano + " de dano!");
                monstro.receberDano(dano);
                break;
            case 2:
                boolean pocaoUsada = heroi.usarPocao();
                if (!pocaoUsada) {
                    System.out.println(" Turno desperdiçado!");
                }
                break;
            case 3:
                heroi.listarInventario();
                System.out.print("\nDigite o número do item (ou -1 para cancelar): ");
                int indice = lerEscolha();
                if (indice >= 0) {
                    boolean itemUsado = heroi.usarItem(indice);
                    if (!itemUsado) {
                        System.out.println(" Ação falhou. Turno desperdiçado!");
                    }
                } else {
                    System.out.println(" Você fechou a mochila e perdeu a vez se distraindo.");
                }
                break;
            default:
                System.out.println(" Opção inválida! Você perdeu a vez.");
        }
    }

    private void turnoMonstro() {
        int dano = monstro.atacar();
        System.out.println("\n " + monstro.getNome() + " atacou causando " + dano + " de dano!");
        heroi.receberDano(dano);
    }

    private boolean resolverFinal() {
        if (heroi.estaVivo()) {
            System.out.println("\n🎉 Parabéns! " + heroi.getNome() + " venceu a batalha!");
            return true;
        } else {
            System.out.println("\n💀 " + heroi.getNome() + " foi derrotado por " + monstro.getNome() + ". Melhor sorte na próxima vez!");
            return false;
        }
    }

    private void exibirCabecahoBatalha() {
        System.out.println("\n⚔️ Batalha Iniciada! ⚔️");
        System.out.println(heroi.getNome() + " vs " + monstro.getNome());
    }

    private void exibirStatusBatalha(){
        heroi.exibirStatus();
        System.out.println();
        monstro.exibirStatus();
    }

    private int lerEscolha() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o buffer
            return -1; 
        }
    }
}