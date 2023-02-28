import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    private List<Block> blocks;
    private Block block;


    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> colors;
        Optional<Block> colored = blocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findAny();

        return colored;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List <Block> materials = new ArrayList<>();
        for (Block b: blocks) {
            if (b.getMaterial().equals(material)){
                materials.add(b);
            }
        }
        return materials;
    }

    @Override
    public int count() {
        int sum = 0;
        for (Block b: blocks) {
            if(block instanceof CompositeBlock){
                sum +=((CompositeBlock) block).getBlocks().size();
            }
            else sum++;
        }
        return sum;
    }
}
