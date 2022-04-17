<?php
class product extends MY_Controller{
	function __construct(){
		parent:: __construct();
		$this->load->model('FoodNews_Model');
	}
	function index(){
		
	}
	function getSlide(){
		$input = array();
		$where = array(
			'priority' =>1
		);
		$data = $this->FoodNews_Model->get_info_rule($where);
		if ($data != null){
		
			
			echo json_encode($data);// return array json 
		}else{
			echo null;
		}
	}
	function getProduct(){
	
		$idCategory =$this->uri->rsegment('3');
		//echo $idCategory;
		
		$where = array(
			'idCategory' =>(int) $idCategory
		);
		$data = $this->FoodNews_Model->getData($where);
		if ($data != null){		
			echo json_encode($data);// return array json 
		}else{
			echo null;
		}
	}
	function product(){
	
	//	$idCategory =$this->uri->rsegment('3');
		//echo $idCategory;
    $where = array();
//	function get_info($id, $field = '')
	$data= $this->FoodNews_Model->get_list($where);
		if ($data != null){		
			echo json_encode($data);// return array json 
		}else{
			echo null;
		}
	}

	
}
?>
