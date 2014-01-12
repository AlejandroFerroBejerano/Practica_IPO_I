package presentacion;

import javax.swing.*;

import java.awt.*;

class MiListCellRenderer extends DefaultListCellRenderer {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	ImageIcon iconoRectangulo;
	ImageIcon iconoArrow;

	public MiListCellRenderer() {
			iconoRectangulo = new ImageIcon(
				MiListCellRenderer.class.getResource("/Recursos/Rectangular-2-32.png"));
		iconoArrow = new ImageIcon(
				MiListCellRenderer.class.getResource("/Recursos/arrow_up.png"));
	}

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean hasFocus) {
		JLabel renderer = (JLabel) defaultRenderer
				.getListCellRendererComponent(list, value, index, isSelected,
						hasFocus);
		if (list.getModel().getElementAt(index) == "Rectangulo") {
			renderer.setIcon(iconoRectangulo);
		} else if (list.getModel().getElementAt(index) == "Señalando") {
			renderer.setIcon(iconoArrow);
		}
		return renderer;
	}
}