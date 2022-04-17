<?php 
class order extends MY_Controller{
	function __construct(){
		parent:: __construct();
		$this->load->model('Order_Model');
	}
	function index(){
		$email = $this->input->post('email');
		$foodID = $this->input->post('foodID');
		$number = $this->input->post('number');
		$note = $this->input->post('note');
		$customerID = $this->input->post('customerID');
		$telephone = $this->input->post('telephone');
		$address = $this->input->post('address');

		$array = new array(
			'idUserName'->$customerID,
			'idfoodNew' ->$foodID,
			'soluong'->$number,
			'address'->$address,
			'phoneNumber'->$telephone,
			'Note'->$note,
			'status'->0//0-> chờ nhà hàng nhận đơn 1-> đag giao 2-> đã giao đến khách hàng 
		);
		if($this->Order_Model->create($array)){
			echo "sussesfull";
		}else{
			echo "error";
		}
	}
}
?>
