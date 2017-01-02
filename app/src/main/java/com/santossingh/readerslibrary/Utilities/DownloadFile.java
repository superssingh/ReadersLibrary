package com.santossingh.readerslibrary.Utilities;

/**
 * Created by santoshsingh on 02/01/17.
 */

//    public class DownloadFile extends AsyncTask<String, Void, Void> {
//
//        @Override
//        protected Void doInBackground(String... strings) {
//            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
//            String fileName = strings[1]+".pdf";  // -> maven.pdf
//            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
//            File folder = new File(extStorageDirectory, "TesTpdf");
//            folder.mkdir();
//
//            File pdfFile = new File(folder, fileName);
//
//            try{
//                pdfFile.createNewFile();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            FileDownloader.downloadFile(fileUrl, pdfFile);
//            return null;
//        }
//    }
//
//
//
//    public static class FileDownloader {
//        private static final int  MEGABYTE = 1024 * 1024;
//
//        public static void downloadFile(String fileUrl, File directory){
//            try {
//
//                URL url = new URL(fileUrl);
//                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//                urlConnection.connect();
//
//                InputStream inputStream = urlConnection.getInputStream();
//                FileOutputStream fileOutputStream = new FileOutputStream(directory);
//                int totalSize = urlConnection.getContentLength();
//
//                byte[] buffer = new byte[MEGABYTE];
//                int bufferLength = 0;
//                while((bufferLength = inputStream.read(buffer))>0 ){
//                    fileOutputStream.write(buffer, 0, bufferLength);
//                }
//                fileOutputStream.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
