import java.io.*;






public class WriteInMultiFiles {
    private File fileA;
    private File fileB;
    private File fileC;

    WriteInMultiFiles(File fileA, File fileB, File fileC) {
        this.fileA = fileA;
        this.fileB = fileB;
        this.fileC = fileC;
    }

    public void startAllThreads() {
        //create new threads
        Thread tOne = new Thread(new WriteInFile(fileA, "From File One"));
        Thread tTwo = new Thread(new WriteInFile(fileB, "From File Two"));
        Thread tThree = new Thread(new WriteInFile(fileA, "From File Three"));
        Thread tFour = new Thread(new WriteInFile(fileB, "From File Four"));
        Thread tFive = new Thread(new WriteInFile(fileA, "From File Five"));
        Thread tSix = new Thread(new WriteInFile(fileC, "From File Six"));
        Thread tSeven = new Thread(new WriteInFile(fileC, "From File Seven"));

        //start all threads
        tOne.start();
        tTwo.start();
        tThree.start();
        tFour.start();
        tFive.start();
        tSix.start();
        tSeven.start();
    }

    private static void writeInFile(File file, String textString) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        for (int i = 0; i < 100; i++) {
            bufferedWriter.write(textString);
            bufferedWriter.newLine();
            Thread.sleep(10);
        }
        bufferedWriter.close();
        fileOutputStream.close();
    }

    class WriteInFile implements Runnable {
        final File file;
        String textString;

        WriteInFile(File file, String textString) {
            this.file = file;
            this.textString = textString;
        }

        @Override
        public void run() {
            synchronized (file) {
                try {
                    writeInFile(file, textString);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
