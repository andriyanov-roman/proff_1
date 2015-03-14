//package shop;
//
//import shop.dao.GoodsDAO;
//import test.reflection.NewAnnotation;
//
//import java.io.*;
//import java.sql.*;
//import java.util.*;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//
//public class View {
//    private Scanner scanner = new Scanner(System.in);
//    private Validator validator = new Validator();
//    private ControlUser controlUser = new ControlUser();
//    private GoodsDAO goodsDAO=new GoodsDAO();
//
//    public View() throws IOException {
//        userControl();
//    }
//
//    private void userControl() throws IOException {
//        System.out.println("Enter Login and password");
//        while (scanner.hasNext()) {
//            try {
//                if (controlUser.checkUser(scanner.next(), scanner.next())) {
//                    startProgram();
//                    break;
//                }
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void startProgram() throws IOException, SQLException, ClassNotFoundException {
//        System.out.println("See report/see sort report/add goods:1/2/3");
//        while (scanner.hasNext()) {
//            String answer = scanner.next();
//            if ("1".equals(answer)) {
//                getReport();
//                break;
//            }
//            if ("2".equals(answer)) {
//                getSortedGoods();
//                break;
//            }
//            if ("3".equals(answer)) {
//                System.out.println("Enter goods " + "Name of good");
//                Good good = new Good();
//                good.setName(getValidatedName());
//                System.out.println("Number of good");
//                good.setNumber(Integer.parseInt(getValidatedNumber()));
//                System.out.println("Bar of good");
//                good.setBarcode(Integer.parseInt(getValidatedBarCode()));
//                System.out.println("Type of good");
//                good.setType(getValidatedType());
//                System.out.println("Write 0 to save file");
//                if ("0".equals(scanner.next())) {
//                    System.out.println("Exit");
//                    writeToFile(good, "/home/artem/IdeaProjects/zaebatiymagazin");
//                    goodsDAO.executeUpdate(good);
//                    System.out.println("continue/zipreport/close:1/2/3");
//                    String answerTwo = scanner.next();
//                    if ("1".equals(answerTwo)) {
//                        userControl();
//                    }
//                    if ("2".equals(answerTwo)) {
//                        createArchive("/home/artem/IdeaProjects/zaebatiymagazin");
//                        break;
//                    }
//                    else{
//                        goodsDAO.readFromDB();
//                        break;
//                    }
//                }
//            }
//            else break;
//        }
//    }
//
//    public void getSortedGoods() throws FileNotFoundException {
//        Set<Good> goods = new TreeSet<>(new SortByNumber());
//        goods.addAll(getGoods());
////        Set<Good> goods = new TreeSet<>(Comparator.comparing(Good::getName).thenComparing(Good::getNumber));
////        goods.addAll(getGoods());
//        for (Good a : goods)
//            System.out.println(a.getName() + "  : " +
//                    a.getNumber() + ", ");
//    }
//
//    public void getReport() {
//        try {
//            String text = new Scanner(new File("/home/artem/IdeaProjects/zaebatiymagazin")).useDelimiter("\\A").next();
//            System.out.println(text);
//        } catch (FileNotFoundException e) {
//            System.out.println("Incorrect directory");
//        }
//    }
//
//    public ArrayList<Good> getGoods() throws FileNotFoundException {
//        ArrayList<String[]> strings = getStrings("/home/artem/IdeaProjects/zaebatiymagazin");
//        ArrayList<Good> goods = new ArrayList<Good>();
//        for (int i = 0; i < strings.size(); i++) {
//            Good good = new Good();
//            good.setName(strings.get(i)[0]);
//            good.setType(strings.get(i)[3]);
//            good.setBarcode(Long.parseLong(strings.get(i)[2]));
//            good.setNumber(Integer.parseInt(strings.get(i)[1]));
//            goods.add(good);
//        }
//        return goods;
//    }
//
//    public String getValidatedName() {
//        String name = scanner.next();
//        if (validator.getName(name)) {
//            return name;
//        } else {
//            System.out.println("Incorrect name");
//            name = getValidatedName();
//        }
//        return name;
//    }
//
//    public String getValidatedNumber() {
//        String number = scanner.next();
//        if (validator.getNumber(number)) {
//            return number;
//        } else {
//            System.out.println("Incorrect number");
//            number = getValidatedNumber();
//        }
//        return number;
//    }
//
//    public String getValidatedBarCode() {
//        String barCode = scanner.next();
//        if (validator.gerBarCode(barCode)) {
//            return barCode;
//        } else {
//            System.out.println("Incorrect Bar Code");
//            barCode = getValidatedBarCode();
//        }
//        return barCode;
//    }
//
//    public String getValidatedType() {
//        String type = scanner.next();
//        if (validator.getType(type)) {
//            return type;
//        } else {
//            System.out.println("Incorrect Type");
//            type = getValidatedType();
//        }
//        return type;
//    }
//
//    public void createArchive(String file) {
//        byte[] buffer = new byte[1024];
//
//        try {
//
//            FileOutputStream fos = new FileOutputStream("/home/artem/IdeaProjects/report.zip");
//            ZipOutputStream zos = new ZipOutputStream(fos);
//            ZipEntry ze = new ZipEntry("report.txt");
//            zos.putNextEntry(ze);
//            FileInputStream in = new FileInputStream(file);
//
//            int len;
//            while ((len = in.read(buffer)) > 0) {
//                zos.write(buffer, 0, len);
//            }
//
//            in.close();
//            zos.closeEntry();
//            zos.close();
//            System.out.println("Done");
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void writeToFile(Object anyObject, String path) {
//        try {
//            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
//            out.println(anyObject.toString());
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<String[]> getStrings(String path) throws FileNotFoundException {
//        ArrayList<String> stringList = new ArrayList<>();
//        ArrayList<String[]> strings = new ArrayList<>();
//        File file = new File(path);
//        Scanner s = new Scanner(file);
//        while (s.hasNext()) {
//            stringList.add(s.next());
//        }
//        for (int i = 0; i < stringList.size(); i++) {
//            strings.add(stringList.get(i).split(":"));
//        }
//        return strings;
//    }
//
//
//}
