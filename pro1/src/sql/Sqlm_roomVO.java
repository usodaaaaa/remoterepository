package sql;
public class Sqlm_roomVO {
	private String roomid;
	private int seat_row;
	private int seat_col;
	
	@Override
	public String toString() {
		return roomid+","+seat_row+","+seat_col;
	}
	
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public int getSeat_row() {
		return seat_row;
	}
	public void setSeat_row(int seat_row) {
		this.seat_row = seat_row;
	}
	public int getSeat_col() {
		return seat_col;
	}
	public void setSeat_col(int seat_col) {
		this.seat_col = seat_col;
	}
}
