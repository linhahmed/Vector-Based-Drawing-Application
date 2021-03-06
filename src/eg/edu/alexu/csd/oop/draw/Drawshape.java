package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.util.*;

import eg.edu.alexu.csd.oop.draw.Shapes.Line;

public abstract class Drawshape implements Shape {
	private double x1,x2,y1,y2;
	private Map<String, Double> properties;
	private Point position;
	private Color backColor, foreColor;
	public ShapeTypes myShapeType;
	private int plugin;
	
	
	public Drawshape() {
		double type  = myShapeType.ordinal();
		this.myShapeType = myShapeType.values()[(int)type];
		properties = new HashMap<String, Double>();
		properties.put("Type", myShapeType.ordinal() *1.0);
		properties.put("foreColor", foreColor.getRGB() * 1.0);
		properties.put("backColor", backColor.getRGB() * 1.0);
		properties.put("x1", (double) x1);
		properties.put("y1", (double) y1);
		properties.put("x2", (double) x2);
		properties.put("y2", (double) y2);
	}

	public Drawshape(ShapeTypes myShapeType, int x1, int y1, int x2, int y2, Color fore, Color back) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.foreColor = fore;
		this.backColor = back;
		this.myShapeType = myShapeType;
		properties = new HashMap<String, Double>();
		properties.put("Type", myShapeType.ordinal() *1.0);
		properties.put("foreColor", foreColor.getRGB() * 1.0);
		properties.put("backColor", backColor.getRGB() * 1.0);
		properties.put("x1", (double) x1);
		properties.put("y1", (double) y1);
		properties.put("x2", (double) x2);
		properties.put("y2", (double) y2);
	}
	
	public Drawshape(ShapeTypes myShapeType, int x1, int y1, int x2, int y2, Color fore, Color back, int plugin) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.foreColor = fore;
        this.backColor = back;
        this.myShapeType = myShapeType;
        position.x = x1;
        position.y = y1;
        properties = new HashMap<String, Double>();
		properties.put("foreColor", foreColor.getRGB() * 1.0);
		properties.put("backColor", backColor.getRGB() * 1.0);
		properties.put("x1", (double) x1);
		properties.put("y1", (double) y1);
		properties.put("x2", (double) x2);
		properties.put("y2", (double) y2);
        this.plugin = plugin;
    }
	
	
	

	public int getPluginId() {
        return plugin;
    }
	
	public void setPosition(Point position) {
		this.position.x = (int) x1;
		this.position.y = (int) y1;
	}

	public Point getPosition() {
		return position;
	}

	public void setProperties(Map<String, Double> properties) {
		properties.put("Type", myShapeType.ordinal() *1.0);
		properties.put("foreColor", foreColor.getRGB() * 1.0);
		properties.put("backColor", backColor.getRGB() * 1.0);
		properties.put("x1", (double) x1);
		properties.put("y1", (double) y1);
		properties.put("x2", (double) x2);
		properties.put("y2", (double) y2);
		this.properties = properties;
	}

	public Map<String, Double> getProperties() {
		return properties;
	}

	public void setColor(Color color) {
		properties.put("foreColor", color.getRGB() * 1.0);
	}

	public Color getColor() {
		return new Color(properties.get("foreColor").intValue());
	}

	public void setFillColor(Color color) {
		properties.put("backColor", color.getRGB() * 1.0);

	}
	

    public ShapeTypes getShapeType() {
        return this.myShapeType;
    }
  
	public void updateAllCoords(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

	public Color getFillColor() {
		return new Color(getProperties().get("backColor").intValue());
	}
	
	public abstract void draw(java.awt.Graphics canvas); // redraw the shape on the canvas

    public abstract Object clone() throws CloneNotSupportedException; 
    public abstract boolean contains(int x, int y);


}
