package com.firelord.opencv.test;

public class Bak {
    //        Mat oMat0 = Imgcodecs.imread("C:/test/src.bmp",
//                Imgcodecs.IMREAD_COLOR);
//        System.out.println(oMat0.cols());
//        System.out.println(oMat0.rows());
//        System.out.println(oMat0.dims());
//        System.out.println(oMat0.channels());
//        System.out.println(oMat0.depth());
//        System.out.println(oMat0.type());
//
//        Mat oMat1 = new Mat();
//        oMat1.create(new Size(3, 3), CvType.CV_8UC3);
//        Mat oMat2 = Mat.eye(3, 3, CvType.CV_8UC3);
//        Mat oMat3 = Mat.eye(new Size(3, 3), CvType.CV_8UC3);
//        Mat oMat4 = Mat.zeros(new Size(3, 3), CvType.CV_8UC3);
//        Mat oMat5 = Mat.ones(new Size(3, 3), CvType.CV_8UC3);
//        Mat oMat6 = oMat5.clone();
//        Mat oMat7 = new Mat();
//        oMat6.copyTo(oMat7);
//
//        Imgcodecs.imwrite("C:/test/dst.bmp", oMat0);
//
//        Mat oMat8 = Mat.zeros(500, 500, CvType.CV_8UC3);
//        Imgproc.ellipse(oMat8, new Point(250, 250), new Size(100, 50),
//                360, 0, 360,
//                new Scalar(0, 0, 255), 2, 8, 0);
//        Imgproc.putText(oMat8, "Basic Drawing Demo", new Point(20, 20),
//                Core.FONT_HERSHEY_PLAIN, 1.0, new Scalar(255, 0, 0), 2);
//        Rect oRect = new Rect();
//        oRect.x = 50;
//        oRect.y = 50;
//        oRect.width = 100;
//        oRect.height = 100;
//        Imgproc.rectangle(oMat8, oRect.tl(), oRect.br(), new Scalar(255, 0, 0),
//                2, 8, 0);
//        Imgproc.circle(oMat8, new Point(400, 400), 50,
//                new Scalar(0, 255, 0), 2, 8, 0);
//        Imgproc.line(oMat8, new Point(10, 10), new Point(490, 490),
//                new Scalar(0, 255, 0), 2, 8, 0);
//        Imgproc.line(oMat8, new Point(10, 490), new Point(490, 10),
//                new Scalar(255, 0, 0), 2, 8, 0);
//        Imgcodecs.imwrite("C:/test/dst.bmp", oMat8);
//
//        oMat8.release();
//
//        Mat src1 = Mat.zeros(400, 400, CvType.CV_8UC3);
//        Mat src2 = new Mat(400, 400, CvType.CV_8UC3);
//        src2.setTo(new Scalar(255, 255, 255));
//        Rect rect = new Rect();
//        rect.x=100;
//        rect.y=100;
//        rect.width = 200;
//        rect.height = 200;
//        Imgproc.rectangle(src1, rect.tl(), rect.br(), new Scalar(0, 255, 0), -1);
//        rect.x=10;
//        rect.y=10;
//        Imgproc.rectangle(src2, rect.tl(), rect.br(), new Scalar(255, 255, 0), -1);
//        Mat dst1 = new Mat();
//        Mat dst2 = new Mat();
//        Mat dst3 = new Mat();
//        Core.bitwise_and(src1, src2, dst1);
//        Core.bitwise_or(src1, src2, dst2);
//        Core.bitwise_xor(src1, src2, dst3);
//        Mat dst = Mat.zeros(400, 1200, CvType.CV_8UC3);
//        rect.x=0;
//        rect.y=0;
//        rect.width=400;
//        rect.height=400;
//        dst1.copyTo(dst.submat(rect));
//        rect.x=400;
//        dst2.copyTo(dst.submat(rect));
//        rect.x=800;
//        dst3.copyTo(dst.submat(rect));
//        dst1.release();
//        dst2.release();
//        dst3.release();
//        Imgcodecs.imwrite("C:/test/dst.bmp", dst);

////        Mat src = Imgcodecs.imread("C:/test/src.bmp", Imgcodecs.IMREAD_COLOR);
//        Mat src = Imgcodecs.imread("C:/test/circle.bmp", Imgcodecs.IMREAD_COLOR);
////        Mat src = Imgcodecs.imread("C:/test/arrow.bmp", Imgcodecs.IMREAD_COLOR);
//        Mat dst = Mat.zeros(src.rows(), src.cols(), CvType.CV_8UC3);
//        Mat edges = new Mat();
//        Imgproc.GaussianBlur(src, src, new Size(3, 3), 0);
//        Mat gray = new Mat();
//        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.Canny(src, edges, 50, 150, 3, true);
//        Core.bitwise_and(src, src, dst, edges);
//        Imgcodecs.imwrite("C:/test/dst.bmp", dst);

//        VisionMatrix oSrc1 = new VisionMatrix("C:/test/circle.bmp");
//        VisionMatrix oDst1 = VisionTools.imgBasicFeature.contoursCalc(oSrc1);
//        oDst1.save("C:/test/dst1.bmp");
//
//        VisionMatrix oSrc2 = new VisionMatrix("C:/test/arrow.bmp");
//        VisionMatrix oDst2 = VisionTools.imgBasicFeature.contoursCalc(oSrc2);
//        oDst2.save("C:/test/dst2.bmp");
}
