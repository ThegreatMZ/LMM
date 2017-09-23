package liumin; 
public class shuzixuanzhuanfangzhen
{ public static void main(String[] args)
{ int width = 6; int height = 6; 
boolean clockwise = false;
outputMatrix(width, height, clockwise);
} 
/*按照指定的长宽和输出方向，从外向内打印一个从 1 开始的数字矩阵，矩阵的开始位置在左上角。 */
private static void outputMatrix(int width, int height, boolean clockwise)
{ 
	// 首先判断最大数字的位数，以决定输出如何对齐
	
	int numLength = (int) Math.log10(width * height) + 1;
	
	// 决定输出的格式（最大位数 + 1个空格）
	
	String format = "%" + (numLength + 1) + "d";
	
	// 定义要输出的二维数组，注意维度是从高到低的 // 此时 matrix 中所有元素的值都是 0
	
	int[][] matrix = new int[height][width];
	
	// 定义一个位置指针和一个计数器，位置指针进行移动，而计数器负责递增，递增后的数字
	// 被填充进矩阵，当 width * height 个数字填充完毕，这个矩阵就完成了。 
	// 注意这里位置指针的第一个元素对应 matrix 的第一个维度 y，第二个元素对应第二个维度 x。
	
	int[] pointer = {0, 0};
	
	int counter = 1; // 定义当前移动的方向：1、2、3、4 分别表示上、右、下、左。
	// 顺时针的起始方向为右，逆时针的起始方向为下。
	
	int direction = clockwise ? 2 : 3; 
	
	// 开始循环填充，每个填充分为三步
	
	for (int i = 1, max = width * height; i <= max; i++) 
	{
		// 1. 填充内容
		
		int y = pointer[0];
		
		int x = pointer[1]; matrix[y][x] = counter;
		
		// 2. 计数器自增
		
		counter += 1; 
		// 3. 移动到下一个位置，因为这地方比较复杂，所以开个方法实现
		direction = move(matrix, width, height, pointer, direction, clockwise); 
		} // 矩阵填充完毕，按照正常的方式循环输出即可 
	for (int y = 0; y < height; y++) 
	{ for (int x = 0; x < width; x++) 
	{ System.out.printf(format, matrix[y][x]);
	} System.out.println(); 
	// 完成一行后输出换行
	}
	}
	/*判断前进方向的下一个位置是否已经填充了数字，如果是则转向 */
	private static int move(int[][] matrix, int width, int height, int[] pointer, 
			int direction, boolean clockwise)
	{ 
		int[] newPointer = moveDirectly(pointer, direction);
				if (isValid(newPointer, matrix, width, height))
		{ System.arraycopy(newPointer, 0, pointer, 0, 2);
		return direction; } 
		direction = turn(direction, clockwise); 
		newPointer = moveDirectly(pointer, direction);
				if (isValid(newPointer, matrix, width, height)) 
		{ System.arraycopy(newPointer, 0, pointer, 0, 2); 
		return direction; } 
		return 0; }
	// 判断矩阵中指定的位置是否可以填充 
	private static boolean isValid(int[] newPointer,
			int[][] matrix, int width, int height)
	{ 
		if (newPointer[0] >= height || newPointer[0] < 0 || newPointer[1] >= width || newPointer[1] < 0)
		{ return false;
		}
		// 位置的内容应该为空
		if (matrix[newPointer[0]][newPointer[1]] != 0) 
		{ return false; } return true; 
		} // 转向。根据我们对 direction 的定义，顺时针就是 +1，逆时针就是 -1
	private static int turn(int direction, boolean clockwise)
	{ int newDirection = clockwise ? direction + 1 : direction - 1; 
	if (newDirection > 4) { newDirection = 1; }
	else if (newDirection < 1) { newDirection = 4;
	} return newDirection; }
	/*朝指定的方向移动 */ 
	private static int[] moveDirectly(int[] pointer, int direction)
	{ int y = pointer[0]; int x = pointer[1]; switch (direction) 
	{ case 1: return new int[]{y - 1, x}; case 2: return new int[]{y, x + 1};
	case 3: return new int[]{y + 1, x}; case 4: return new int[]{y, x - 1}; } 
	throw new IllegalArgumentException("方向不正确: " + direction);

	}
	
}
