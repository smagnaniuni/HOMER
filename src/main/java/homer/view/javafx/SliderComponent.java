package homer.view.javafx;

import homer.view.StateSelector;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

/**
 * Basic slider that displays its value.
 */
public final class SliderComponent extends VBox implements StateSelector<Double> {

    private Slider slider;
    private final Label label;

    /**
     * 
     * @param max
     * @param min
     * @param value
     * @param onDragDone the event that gets triggered on drag done.
     */
    public SliderComponent(final double max, final double min, final double value,
            Runnable onDragDone) {
        label = new Label("" + value);
        this.slider = new Slider(min, max, value);
        this.slider.setShowTickLabels(true);
        this.slider.setShowTickMarks(true);
        this.getChildren().addAll(this.slider, this.label);
        this.slider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    public void changed(javafx.beans.value.ObservableValue<? extends Number> observable,
                            Number oldValue, Number newValue) {
                        updateValue((Double) newValue);
                        System.out.println(""+oldValue +"->"+newValue);
                        onDragDone.run();
                    };
                });
    }

    private void updateValue(final Double value) {
        this.slider.setValue(value);
        this.label.setText(Double.toString(value));
    }

    @Override
    public Double getState() {
        return this.slider.getValue();
    }

    @Override
    public void setState(Double state) {
        updateValue(state);
    }

}
