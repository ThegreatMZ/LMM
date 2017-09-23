package liumin; 
public class shuzixuanzhuanfangzhen
{ public static void main(String[] args)
{ int width = 6; int height = 6; 
boolean clockwise = false;
outputMatrix(width, height, clockwise);
} 
/*����ָ���ĳ����������򣬴������ڴ�ӡһ���� 1 ��ʼ�����־��󣬾���Ŀ�ʼλ�������Ͻǡ� */
private static void outputMatrix(int width, int height, boolean clockwise)
{ 
	// �����ж�������ֵ�λ�����Ծ��������ζ���
	
	int numLength = (int) Math.log10(width * height) + 1;
	
	// ��������ĸ�ʽ�����λ�� + 1���ո�
	
	String format = "%" + (numLength + 1) + "d";
	
	// ����Ҫ����Ķ�ά���飬ע��ά���ǴӸߵ��͵� // ��ʱ matrix ������Ԫ�ص�ֵ���� 0
	
	int[][] matrix = new int[height][width];
	
	// ����һ��λ��ָ���һ����������λ��ָ������ƶ�������������������������������
	// ���������󣬵� width * height �����������ϣ�������������ˡ� 
	// ע������λ��ָ��ĵ�һ��Ԫ�ض�Ӧ matrix �ĵ�һ��ά�� y���ڶ���Ԫ�ض�Ӧ�ڶ���ά�� x��
	
	int[] pointer = {0, 0};
	
	int counter = 1; // ���嵱ǰ�ƶ��ķ���1��2��3��4 �ֱ��ʾ�ϡ��ҡ��¡���
	// ˳ʱ�����ʼ����Ϊ�ң���ʱ�����ʼ����Ϊ�¡�
	
	int direction = clockwise ? 2 : 3; 
	
	// ��ʼѭ����䣬ÿ������Ϊ����
	
	for (int i = 1, max = width * height; i <= max; i++) 
	{
		// 1. �������
		
		int y = pointer[0];
		
		int x = pointer[1]; matrix[y][x] = counter;
		
		// 2. ����������
		
		counter += 1; 
		// 3. �ƶ�����һ��λ�ã���Ϊ��ط��Ƚϸ��ӣ����Կ�������ʵ��
		direction = move(matrix, width, height, pointer, direction, clockwise); 
		} // ���������ϣ����������ķ�ʽѭ��������� 
	for (int y = 0; y < height; y++) 
	{ for (int x = 0; x < width; x++) 
	{ System.out.printf(format, matrix[y][x]);
	} System.out.println(); 
	// ���һ�к��������
	}
	}
	/*�ж�ǰ���������һ��λ���Ƿ��Ѿ���������֣��������ת�� */
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
	// �жϾ�����ָ����λ���Ƿ������� 
	private static boolean isValid(int[] newPointer,
			int[][] matrix, int width, int height)
	{ 
		if (newPointer[0] >= height || newPointer[0] < 0 || newPointer[1] >= width || newPointer[1] < 0)
		{ return false;
		}
		// λ�õ�����Ӧ��Ϊ��
		if (matrix[newPointer[0]][newPointer[1]] != 0) 
		{ return false; } return true; 
		} // ת�򡣸������Ƕ� direction �Ķ��壬˳ʱ����� +1����ʱ����� -1
	private static int turn(int direction, boolean clockwise)
	{ int newDirection = clockwise ? direction + 1 : direction - 1; 
	if (newDirection > 4) { newDirection = 1; }
	else if (newDirection < 1) { newDirection = 4;
	} return newDirection; }
	/*��ָ���ķ����ƶ� */ 
	private static int[] moveDirectly(int[] pointer, int direction)
	{ int y = pointer[0]; int x = pointer[1]; switch (direction) 
	{ case 1: return new int[]{y - 1, x}; case 2: return new int[]{y, x + 1};
	case 3: return new int[]{y + 1, x}; case 4: return new int[]{y, x - 1}; } 
	throw new IllegalArgumentException("������ȷ: " + direction);

	}
	
}
