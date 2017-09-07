
public class MyStudent implements Stady{

	private Stady stady;

	public MyStudent(Stady stady) {
		super();
		this.stady = stady;
	}

	@Override
	public void style() {

		stady.style();
		System.out.println("安静的没这么快");
		System.out.println("我会学着忘记你");
		System.out.println("是因为我太爱你");
	}
	
	
}
