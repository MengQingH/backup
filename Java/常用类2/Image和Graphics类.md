# Image
Image类为一个抽象类，BufferedImage为该类的一个子类，可以在内存中创建一个图片或者把现有的图片加载到内存中，用于获取图片的信息或对图片进行相关操作。

## 方法：
* BufferedImage(int width, int height, int imageType)：创建一个BufferedImage对象
* ImageIO.read(new FileInputStream(imgPath))：返回一个图片的BufferedImage对象
* getGraphics()：获取一个Image对象的Graphics对象，用来绘制图形
* createGraphics()：获取一个Graphics2D图像
* getHeight()：
* getWidth()：
* getType()：

# Graphics
Graphics类为绘图类，提供了基本的绘图方法，画出的图像相当于在原来的图片上面显示出来。其子类Graphics2D添加了更多的绘图方法。
## Graphics方法
1. 设置：
    * void setBackground(Color color):设置背景（擦除后显示该背景）
    * void setStroke(Stroke s):设置笔画的轮廓特性（如画笔宽度、实线、虚线等）（Graphics2D方法）
    * void setColor(Color c):设置画笔颜色
    * void clearRect(int x, int y, int width, int height):擦除某一区域(擦除后显示背景颜色)
    * void dispose():销毁画笔
2. 线段
    * void drawLine(int x1, int y1, int x2, int y2):
    * void drawPolyline(int xPoints[], int yPoints[], int nPoints):
3. 多边形
    * void drawRect(int x, int y, int width, int height)：绘制一个矩形（空心）
    * void fillRect(int x, int y, int width, int height)：填充一个矩形（实心）
    * void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight):绘制一个圆角矩形
    * void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight):填充一个圆角矩形
4. 圆弧
    * void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle):绘制一个圆弧
    * void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle):填充一个圆弧，即扇形
    * void drawOval(int x, int y, int width, int height):绘制一个椭圆
    * void fillOval(int x, int y, int width, int height):填充一个椭圆
5. 字体
    * void setFont(Font font):设置字体样式
    * void drawString(String s,int x,int y):绘制一段文本，xy坐标为文本序列左下角的位置

## 验证码demo
```java

//创建一张图片，宽高的单位为像素，第三个参数需要传入图片的类型
BufferedImage image = new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);

//获取Graphics2D对象，是在原有图片的上面画图
Graphics2D gra = image.createGraphics();
//向画板上画图必须先设置画笔，传入一个Color对象，可以使用Color类中的常量
gra.setColor(Color.white);

//填充一个矩形区域
gra.fillRect(0,0,image.getWidth(),image.getHeight());

//向图片中添加字符串
List<Integer> list = new ArrayList<>();
Random random = new Random();
for (int i = 0; i < 4; i++) {
    list.add(random.nextInt(10));
}
System.out.println(list.toString());
gra.setFont(new Font(null,Font.BOLD,60));
Color[] colors = new Color[]{Color.red,Color.cyan,Color.black,Color.green,Color.MAGENTA};
for (int i = 0; i < list.size(); i++) {
    //产生随机颜色和位置
    gra.setColor(colors[random.nextInt(colors.length)]);
    gra.drawString(list.get(i)+"" ,i*40,50+(random.nextInt(21)-10));
}

//划横线
for (int i = 0; i < 2; i++) {
    gra.drawLine(0,random.nextInt(101),200,random.nextInt(101));
}

ServletOutputStream outputStream = response.getOutputStream();
//ImageIO是一个工具类,可以把指定的图片添加到输出流中
ImageIO.write(image,"jpg",outputStream);
```