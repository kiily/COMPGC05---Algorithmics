package lecture1;

public class ComplexNumber {
	
	private double real;
	private double imaginary;
	
	
	/*
	 * The complex number is a data structure which consists of a pair of real numbers.
	 */
	public ComplexNumber(double r, double i){
		real = r;
		imaginary = i;
	}
	
	public double real(){
		return real;
	}
	
	public double imaginary(){
		return imaginary;
	}
	
	
	/*
	 * Calling the real() and imaginary() getters as the variables are private
	 * For real numbers:
	 * (a+bi) + (c+di) = (a+c) + (b+d)*i 
	 */
	public ComplexNumber add(ComplexNumber c){
		double newReal = real +c.real();
		double newImaginary = imaginary + c.imaginary();
		
		
		return new ComplexNumber(newReal,newImaginary);
		
	}
	
	
	/*
	 * Calling the real() and imaginary() getters as the variables are private
	 * For real numbers:
	 * (a+bi) * (c+di) = (ac+bd) + (ad+bc)*i 
	 */
	public ComplexNumber multiply(ComplexNumber c){
		double newReal = real*c.real() + imaginary*c.imaginary();
		double newImaginary = real *c.imaginary() + imaginary*c.real();
		
		return new ComplexNumber(newReal,newImaginary);
		
	}
	
	
}
