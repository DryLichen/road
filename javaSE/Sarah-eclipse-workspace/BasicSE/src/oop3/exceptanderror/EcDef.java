package oop3.exceptanderror;

public class EcDef extends Exception {
	
	static final long serialVersionUID = -48923492387429L;
	
	public EcDef() {}
	public EcDef(String msg) {
		super(msg);
	}
	
}
