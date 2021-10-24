package designpatterns

enum class Direction { Forward, Backward, Right, Left }

interface MazeExplorer {
    fun explore(): List<Direction>
}

class DumbExplorer: MazeExplorer {
    override fun explore(): List<Direction> {
        TODO("Choose a random direction every time")
    }
}

class MethodicalExplorer: MazeExplorer {
    override fun explore(): List<Direction> {
        TODO("Always follow the right wall")
    }
}

class MemorizingExplorer: MazeExplorer {
    override fun explore(): List<Direction> {
        TODO("Explore branch by branch, remembering which are blocked")
    }
}