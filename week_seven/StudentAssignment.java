package week_seven;

public class StudentAssignment {
    public static void main(String[] args) {
        DoubleArraySeq seq = new DoubleArraySeq();
        int answer = 1;
        int size = 0;
        double current = 0.0;
        String content = "";
        boolean isCurrent = false;
        int capacity;

        size = seq.size();
        System.out.println("1) " + size);

        capacity = seq.getCapacity();
        System.out.println("2) " + capacity);

        isCurrent = seq.isCurrent();
        System.out.println("3) " + isCurrent);

        if (isCurrent) {
            current = seq.getCurrent();
            System.out.println("4) " + current);
        } else {
            System.out.println("4) " + current);
        }

        content = seq.toString(); // 5. content = _____________
        System.out.println("5) " + content);
        seq.trimToSize();

        capacity = seq.getCapacity(); // 6. capacity = ____________
        System.out.println("6) " + capacity);
        seq.ensureCapacity(5);

        capacity = seq.getCapacity(); // 7. capacity = ____________
        System.out.println("7) " + capacity);
        seq.addAfter(1.1);

        content = seq.toString(); // 8. content = _____________
        System.out.println("8) " + content);

        size = seq.size(); // 9. size = _________________
        System.out.println("9) " + size);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 10. current = ______________
            System.out.println("10) " + current);
        } else {
            System.out.println("10) " + current);
        }

        seq.addBefore(2.2);
        content = seq.toString(); // 11. content = _____________
        System.out.println("11) " + content);
        size = seq.size(); // 12. size = ________________
        System.out.println("12) " + size);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 13. current = ______________
            System.out.println("13) " + current);
        } else {
            System.out.println("13) " + current);
        }

        seq.addAfter(3.3);
        content = seq.toString(); // 14. content = ______________
        System.out.println("14) " + content);

        size = seq.size(); // 15. size = _________________
        System.out.println("15) " + size);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 16. current = ______________
            System.out.println("16) " + current);
        } else {
            System.out.println("16) " + current);
        }

        seq.advance();
        content = seq.toString(); // 17. content = ________________
        System.out.println("17) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 18. current = ______________
            System.out.println("18) " + current);
        } else {
            System.out.println("18) " + current);
        }

        seq.advance();
        content = seq.toString(); // 19. content = ________________
        System.out.println("19) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 20. current = ______________
            System.out.println("20) " + current);
        } else {
            System.out.println("20) " + current);
        }

        seq.addBefore(4.4);
        content = seq.toString(); // 21. content = ________________
        System.out.println("21) " + content);

        size = seq.size(); // 22. size = _________________
        System.out.println("22) " + size);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 23. current = ______________
            System.out.println("23) " + current);
        } else {
            System.out.println("23) " + current);
        }

        seq.advance();
        content = seq.toString(); // 24. content = ________________
        System.out.println("24) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 25. current = _______________
            System.out.println("25) " + current);
        } else {
            System.out.println("25) " + current);
        }

        seq.advance();
        content = seq.toString(); // 26. content = ________________
        System.out.println("26) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 27. current = ________________
            System.out.println("27) " + current);
        } else {
            System.out.println("27) " + current);
        }

        seq.advance();
        content = seq.toString(); // 28. content = ________________
        System.out.println("28) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 29. current = ________________
            System.out.println("29) " + current);
        } else {
            System.out.println("29) " + current);
        }

        seq.advance();
        content = seq.toString(); // 30. content = ________________
        System.out.println("30) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 31. current = ________________
            System.out.println("31) " + current);
        } else {
            System.out.println("31) " + current);
        }

        seq.start();
        content = seq.toString(); // 32. content = ________________
        System.out.println("32) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 33. current = ________________
            System.out.println("33) " + current);
        } else {
            System.out.println("33) " + current);
        }

        seq.advance();
        content = seq.toString(); // 34. content = ________________
        System.out.println("34) " + content);

        seq.removeCurrent();
        content = seq.toString(); // 35. content = ________________
        System.out.println("35) " + content);

        size = seq.size(); // 36. size = ___________________
        System.out.println("36) " + size);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 37. current = ________________
            System.out.println("37) " + current);
        } else {
            System.out.println("37) " + current);
        }

        seq.removeCurrent();
        content = seq.toString(); // 38. content = ________________
        System.out.println("38) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 39. current = ________________
            System.out.println("39) " + current);
        } else {
            System.out.println("39) " + current);
        }

        seq.removeCurrent();
        content = seq.toString(); // 40. content = ________________
        System.out.println("40) " + content);

        if (seq.isCurrent()) {
            current = seq.getCurrent(); // 41. current = ________________
            System.out.println("41) " + current);
        } else {
            System.out.println("41) " + current);
        }

        content = seq.toString(); // 42. content = ________________
        System.out.println("42) " + content);

        seq.start();
        content = seq.toString(); // 43. content = ________________
        System.out.println("43) " + content);

        seq.removeCurrent();
        content = seq.toString(); // 44. content = ________________
        System.out.println("44) " + content);

    }
}
