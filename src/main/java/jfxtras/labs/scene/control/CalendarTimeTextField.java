/**
 * Copyright (c) 2011, JFXtras
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package jfxtras.labs.scene.control;

import java.util.Calendar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;

/**
 * A textField with displays a calendar (time) with a icon to popup the CalendarTimePicker
 * The calendar is (and should) be treated as immutable. That means the setter is not used, but when a value is changed a new instance (clone) is put in the calendar property.
 * 
 * To change the icon use:
 * .CalendarTimeTextField .icon  {
 *     -fx-image: url("AlternateCalendarIcon.jpg");
 * }
 * 
 * @author Tom Eugelink
 */
public class CalendarTimeTextField extends Control
{
	// ==================================================================================================================
	// CONSTRUCTOR
	
	/**
	 * 
	 */
	public CalendarTimeTextField()
	{
		construct();
	}
	
	/*
	 * 
	 */
	private void construct()
	{
		// setup the CSS
		// the -fx-skin attribute in the CSS sets which Skin class is used
		this.getStyleClass().add(this.getClass().getSimpleName());
		
		// this is apparently needed for good focus behavior
		setFocusTraversable(false);
	}

	/**
	 * Return the path to the CSS file so things are setup right
	 */
	@Override protected String getUserAgentStylesheet()
	{
		return this.getClass().getResource("/jfxtras/labs/internal/scene/control/" + this.getClass().getSimpleName() + ".css").toString();
	}
	
	// ==================================================================================================================
	// PROPERTIES
	
	/** Value: */
	public ObjectProperty<Calendar> valueProperty() { return valueObjectProperty; }
	final private ObjectProperty<Calendar> valueObjectProperty = new SimpleObjectProperty<Calendar>(this, "value", null);
	public Calendar getValue() { return valueObjectProperty.getValue(); }
	public void setValue(Calendar value) { valueObjectProperty.setValue(value); }
	public CalendarTimeTextField withValue(Calendar value) { setValue(value); return this; }

	/** MinuteStep */
	public ObjectProperty<Integer> minuteStepProperty() { return minuteStepProperty; }
	final private SimpleObjectProperty<Integer> minuteStepProperty = new SimpleObjectProperty<Integer>(this, "minuteStep", 1);
	public Integer getMinuteStep() { return minuteStepProperty.getValue(); }
	public void setMinuteStep(Integer value) { minuteStepProperty.setValue(value); }
	public CalendarTimeTextField withMinuteStep(Integer value) { setMinuteStep(value); return this; } 


	/** ShowLabels */
	public ObjectProperty<Boolean> showLabelsProperty() { return showLabelsProperty; }
	final private SimpleObjectProperty<Boolean> showLabelsProperty = new SimpleObjectProperty<Boolean>(this, "showLabels", true);
	public Boolean getShowLabels() { return showLabelsProperty.getValue(); }
	public void setShowLabels(Boolean value) { showLabelsProperty.setValue(value); }
	public CalendarTimeTextField withShowLabels(Boolean value) { setShowLabels(value); return this; } 
	
	/** PromptText: */
	public ObjectProperty<String> promptTextProperty() { return promptTextObjectProperty; }
	final private ObjectProperty<String> promptTextObjectProperty = new SimpleObjectProperty<String>(this, "promptText", null);
	public String getPromptText() { return promptTextObjectProperty.get(); }
	public void setPromptText(String value) { promptTextObjectProperty.set(value); }
	public CalendarTimeTextField withPromptText(String value) { setPromptText(value); return this; }

	// ==================================================================================================================
	// EVENTS
	
	// ==================================================================================================================
	// BEHAVIOR
	
}
