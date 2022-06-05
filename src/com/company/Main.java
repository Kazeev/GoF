package com.company;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    static TicketRecords ticketRecords = new TicketRecords();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------\n");
        System.out.println("(1) Добавить посещение/абонемент");
        System.out.println("(2) Получить список посещений");
        System.out.println("(3) Сохранить список посещений");
        System.out.println("(4) Загрузить список посещений из файла");
        System.out.print("--> ");
        try {
            switch (in.nextInt()) {
                case 1 -> {
                    System.out.println("Выбрать тип посещения: " + Stream.of(TicketType.values())
                        .map(ticketType -> ticketType.name)
                        .collect(Collectors.joining("")));
                    System.out.print("--> ");
                    switch (in.nextInt()) {
                        case 1 -> {
                            SingleTicketFactory singleTicket = (SingleTicketFactory) TicketAbstractFactory.createTicket(TicketType.SingleTicketFactory);
                            System.out.println("Выбрать уровень посещения: " + Stream.of(SingleTicketType.values())
                                .map(ticketType -> ticketType.name)
                                .collect(Collectors.joining("")));
                            System.out.print("--> ");
                            try {
                                switch (in.nextInt()) {
                                    case 1 -> {
                                        SingleTicket single = (SingleTicket) singleTicket.create(SingleTicketType.SingleDayPremiumLevel);
                                        try {
                                            System.out.print("Имя клиента: ");
                                            single.setUserName(in.next());
                                            System.out.print("Дата посещения: ");
                                            single.setDay(LocalDate.parse(in.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                                            single.buy();
                                            ticketRecords.addTicketRecords(single);
                                        } catch (Exception e) {
                                            System.out.println("Данные некорректные");
                                        }
                                        main(args);
                                    }
                                    case 2 -> System.out.println("2");
                                    default -> throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("Неправильный выбор типа посещения");
                                main(args);
                            }
                        }
                        case 2 -> {
                            SeasonTicketFactory seasonTicket = (SeasonTicketFactory) TicketAbstractFactory.createTicket(TicketType.SeasonTicketFactory);
                            System.out.println("Выберете уровень посещения: " + Stream.of(SeasonTicketType.values())
                                .map(ticketType -> ticketType.name)
                                .collect(Collectors.joining("")));
                            System.out.print("--> ");
                            try {
                                switch (in.nextInt()) {
                                    case 1 -> {
                                        SeasonTicket season = (SeasonTicket) seasonTicket.create(SeasonTicketType.PremiumLevel);
                                        try {
                                            System.out.print("Имя клиента: ");
                                            season.setUserName(in.next());
                                            System.out.print("Даты посещения(Через запятую): ");
                                            season.setDays(Arrays.stream(in.next().split(","))
                                                .map(s -> LocalDate.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                                                .collect(Collectors.toList()));
                                            season.buy();
                                        } catch (Exception e) {
                                            System.out.println("Данные некорректные");
                                        }

                                        ticketRecords.addTicketRecords(season);
                                        main(args);
                                    }
                                    case 2 -> System.out.println("2");
                                    default -> throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("Неправильный выбор уровеня посещения");
                                main(args);
                            }
                        }
                    }
                }
                case 2 -> {
                    Iterator iterator = ticketRecords.getIterator();
                    int i = 1;
                    System.out.println("Записи:");
                    while (iterator.hasNext()) {
                        System.out.println(i++ + "=" + iterator.next());
                    }
                    if (i == 1) System.out.println("Нет записей");
                    main(args);
                }
                case 3 -> {
                    try (PrintWriter out = new PrintWriter("Ticket.txt")) {
                        Iterator iterator = ticketRecords.getIterator();
                        int i = 1;
                        while (iterator.hasNext()) {
                            out.println(i++ + "=" + iterator.next());
                        }
                    }
                    System.out.println("Список записей сохранён");
                    main(args);
                }
                case 4 -> {
                    List<String> files = Files.readAllLines(Path.of("Ticket.txt"));
                    if (files.size() != 0) {
                        ticketRecords.ticketRecords.addAll(files.stream().map(s -> s.split("=")[1]).collect(Collectors.toList()));
                        System.out.println("Список записей згружен");
                    } else {
                        System.out.println("Фйл списка записей пуст");
                    }
                    main(args);
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Неправильный выбор главного меню");
            e.printStackTrace();
            main(args);
        }

    }

}
