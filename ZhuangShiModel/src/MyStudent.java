
public class MyStudent implements Stady{

	private Stady stady;

	public MyStudent(Stady stady) {
		super();
		this.stady = stady;
	}

	@Override
	public void style() {

		stady.style();
		System.out.println("������û��ô��");
		System.out.println("�һ�ѧ��������");
		System.out.println("����Ϊ��̫����");
	}
	
	
}
