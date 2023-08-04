package rarula.symmetricraft.util

class Direction {
    companion object {
        fun getDirectionTypeFromYaw(yaw: Float): DirectionType {
            // SOUTH
            if (((337.5 <= yaw && yaw < 360) || (0 <= yaw && yaw < 22.5)) || ((-22.5 < yaw && yaw <= -0) || (-360 < yaw && yaw <= -337.5))) {
                return DirectionType.SOUTH
            }

            // SOUTH EAST
            else if ((292.5 <= yaw && yaw < 337.5) || (-67.5 < yaw && yaw <= -22.5)) {
                return DirectionType.SOUTH_EAST
            }

            // EAST
            else if ((247.5 <= yaw && yaw < 292.5) || (-112.5 < yaw && yaw <= -67.5)) {
                return DirectionType.EAST
            }

            // NORTH EAST
            else if ((202.5 <= yaw && yaw < 247.5) || (-157.5 < yaw && yaw <= -112.5)) {
                return DirectionType.NORTH_EAST
            }

            // NORTH
            else if ((157.5 <= yaw && yaw < 202.5) || (-202.5 < yaw && yaw <= -157.5)) {
                return DirectionType.NORTH
            }

            // NORTH WEST
            else if ((112.5 <= yaw && yaw < 157.5) || (-247.5 < yaw && yaw <= -202.5)) {
                return DirectionType.NORTH_WEST
            }

            // WEST
            else if ((67.5 <= yaw && yaw < 112.5) || (-292.5 < yaw && yaw <= -247.5)) {
                return DirectionType.WEST
            }

            // SOUTH WEST
            else {
                return DirectionType.SOUTH_WEST
            }
        }
    }
}
