uniform highp mat4 transition_matrix;

attribute vec4 color;
attribute vec4 position;
attribute vec2 texture_coordinate;

varying lowp vec4 frag_color;
varying lowp vec2 frag_coordinate;

void main(void) {
    frag_color = color;
    frag_coordinate = texture_coordinate;
    gl_Position = transition_matrix * position;
}
