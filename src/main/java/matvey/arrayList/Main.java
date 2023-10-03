package matvey.arrayList;

public class Main {
    public static void main(String[] args) {
            //задача с словами
            Words words = new Words();
            words.massCheckSet();

            //задача с телефонной книжкой
            PhoneNotebook phony = new PhoneNotebook();
            phony.addPhones("Бальмонт", 893332416, 87646788);
            phony.addPhones("Шолохов", 85321689);
            phony.addPhones("Блок", 893332416);
            phony.addPhones("Мамин-Сибиряк", 867524436, 893332416);
            phony.addPhones("Лесков", 825636783);
            phony.addPhones("Рыжий", 867534790);
            phony.addPhones("Твардовский", 867524436);
            phony.addPhones("Лермонтов", 876429369);
            phony.addPhones("Маяковский", 856457472, 876429369);
            phony.addPhones("Чехов", 832567379);
            phony.addPhones("Некрасов", 874565392);

            System.out.println(phony.get("Бальмонт"));
            System.out.println(phony.get("Маяковский"));
            System.out.println(phony.get("Лермонтов"));

            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);
            phony.addPhones("Бальмонт", 999999999);


            System.out.println(phony.get("Бальмонт"));
            System.out.println(phony.get("Shumilin"));

    }
}
