<?php
class FoodNews_Model extends MY_Model{
	var $table = 'foodnews';
	public function getData($where){
	$this->db->select('*');
	$this->db->from('foodnews'); // this is first table name
	$this->db->join('restaurant', 'restaurant.id = foodnews.idRestaurant'); // this is second table name with both table ids
	$this->db->where($where);
	$query = $this->db->get();
	return $query->result();
	}
}
?>
