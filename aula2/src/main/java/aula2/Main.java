package aula2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exibirTitulo();
        
        System.out.println("Digite o nome do herói:");
        String nomeHeroi = scanner.next();
        Heroi heroi = new Heroi(nomeHeroi, 3000, 20, 10);
        
        // Atividade 02: Dando itens iniciais ao herói
        heroi.adicionarItem(new Item("Poção Pequena", "cura", 20));
        heroi.adicionarItem(new Item("Poção Grande", "cura", 50));
        heroi.adicionarItem(new Item("Amuleto de Força", "ataque", 5));

        System.out.println("\n Heroi criado com sucesso!");
        heroi.exibirStatus();
        
        // Atividade 01: Adicionando Emoji no construtor e Novos Monstros
        Monstro[] monstros = {
                new Monstro("Goblin", "👺", 50, 15, 5, 20),
                new Monstro("Orc", "👹", 80, 25, 10, 40),
                new Monstro("Troll", "👾", 120, 30, 15, 60),
                // Novos Monstros
                new Monstro("Vampiro", "🧛", 80, 22, 7, 60),
                new Monstro("Esqueleto", "💀", 50, 15, 3, 30)
        };
        
        int vitorias = 0;
        
        for (Monstro monstro: monstros) {
            System.out.println("\n Você avança pela masmorra...");
            System.out.println(" Um " + monstro.getNome() + " aparece!");
            System.out.println(" Prepare-se para a batalha!");
            System.out.println("\n [1] para lutar");
            System.out.println(" [2] para fugir");
            System.out.print("Escolha: ");
            
            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 1;
                scanner.nextLine();
            }
            
            if (opcao == 2) {
                System.out.println(" Você fugiu da batalha!");
                continue;
            }
            
            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.iniciar();
            
            if (venceu) {
                vitorias++;
                heroi.ganharXp(monstro.getXpRecompensa());
                
                // Recompensa opcional após vitória
                System.out.println("\n🎁 O monstro deixou cair um item!");
                heroi.adicionarItem(new Item("Erva Medicinal", "cura", 15));

                System.out.println("\nPressione [ENTER] para continuar...");
                scanner.nextLine(); // Limpa o buffer do enter anterior
                scanner.nextLine(); // Aguarda o enter do usuário
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return; // Encerra o jogo se perder
            }
       }
       
       exibirVitorias(nomeHeroi, vitorias);
       scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("--------------------------------");
        System.out.println("   BEM-VINDO AO RPG DE CONSOLE!   ");
        System.out.println("     Prepare-se para a aventura!      ");
        System.out.println("-------------------------------- ");
    }

    private static void exibirGameOver(String nomeHeroi, int vitorias, int xp) {
        System.out.println("--------------------------------");
        System.out.println("           GAME OVER!            ");
        System.out.println("---------------------------------");
        System.out.println("Fim da jornada de " + nomeHeroi);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("XP acumulada: " + xp);
    }

    private static void exibirVitorias(String nomeHeroi, int vitorias) {
        System.out.println("--------------------------------");
        System.out.println("     PARABÉNS, " + nomeHeroi.toUpperCase() + "!     ");
        System.out.println("   Você venceu todos os monstros!   ");
        System.out.println("Vitorias: " + vitorias);
        System.out.println("--------------------------------");
    }
}