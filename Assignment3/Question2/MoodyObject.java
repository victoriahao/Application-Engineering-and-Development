abstract public class MoodyObject{
	
		protected abstract String getMood();
		
		protected abstract void expressFeelings();
		
		public void queryMood() {
			getMood();
		}
}